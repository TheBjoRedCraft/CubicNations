package dev.thebjoredcraft.cubicnations.utils.database;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.sql.*;

public class MySQL {

    private static Connection con;

    public static Connection getConnection() {
        return MySQL.con;
    }

    public static void setConnection(final String host, final String user, final String password, final String database, final String port) {
        if (host == null || user == null || database == null){
            return;
        }
        disconnect(false);
        try {
            MySQL.con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true&useSSL=false", user, password);
            Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"[WildSQL]"+ChatColor.GREEN + "SQL verbunden.");
        }
        catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"[WildSQL]"+ChatColor.RED + "SQL Connect Error: " + e.getMessage());
        }
    }

    public static void connect() {
        connect(true);
    }

    private static void connect(final boolean message) {
        if (!isConnected()) {
            final String host = "db.hexle.at";
            final String user = "00028_db_user";
            final String password = "HunGOFyRHp8hdm72Tn1BcGyw1e5dm9-ugsskYS6U";
            final String database = "djhase";
            final String port = "3306";
            setConnection(host, user, password, database, port);
        }
    }

    public static void disconnect() {
        disconnect(true);
    }

    private static void disconnect(final boolean message) {
        try {
            if (isConnected()) {
                MySQL.con.close();
                if (message) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"[WildSQL]"+ChatColor.GREEN + "SQL getrennt.");
                }
            }
            else if (message) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"[WildSQL]"+ChatColor.RED + "SQL Disconnect Error: Keine Verbindung zu trennen.");
            }
        }
        catch (Exception e) {
            if (message) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+ "[WildSQL]"+ChatColor.RED + "SQL Disconnect Error: " + e.getMessage());
            }
        }
        MySQL.con = null;
    }

    public static void reconnect() {
        disconnect();
        connect();
    }

    public static boolean isConnected() {
        if (MySQL.con != null) {
            try {
                return !MySQL.con.isClosed();
            }
            catch (Exception e) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"[WildSQL]"+ChatColor.RED + "SQL Connection:");
                Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"[WildSQL]"+ChatColor.RED + "Error: " + e.getMessage());
            }
        }
        return false;
    }

    @SuppressWarnings("CatchMayIgnoreException")
    public static boolean update(final String command) {
        System.out.println("SQL "+command);
        if (command == null) {
            return false;
        }
        boolean result = false;
        connect(false);
        try {
            final Statement st = getConnection().createStatement();
            st.executeUpdate(command);
            st.close();
            result = true;
        }
        catch (Exception e) {
            final String message = e.getMessage();
            if (message != null) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"[WildSQL]"+ChatColor.RED + "SQL Update:");
                Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"[WildSQL]"+ChatColor.RED + "Command: " + command);
                Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"[WildSQL]"+ChatColor.RED + "Error: " + message);
            }
        }
        disconnect(false);
        return result;
    }

    public static ResultSet query(final String command) {
        if (command == null) {
            return null;
        }
        connect(false);
        ResultSet rs = null;
        try {
            final Statement st = getConnection().createStatement();
            rs = st.executeQuery(command);
        }
        catch (SQLException e) {
            final String message = e.getMessage();
            if (message != null) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"[WildSQL]"+ChatColor.RED + "SQL Query:");
                Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"[WildSQL]"+ChatColor.RED + "Command: " + command);
                Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE+"[WildSQL]"+ChatColor.RED + "Error: " + message);
            }
        }
        return rs;
    }

}
