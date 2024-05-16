package dev.thebjoredcraft.cubicnations;

import dev.thebjoredcraft.cubicnations.manager.WhitelistManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class CubicNations extends JavaPlugin {
    public static WhitelistManager whitelistManager;
    public static CubicNations instance;
    public static Boolean started = false;
    public static List<String> bypassWhitelistPlayers = new ArrayList<>();

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        whitelistManager = new WhitelistManager();

        bypassWhitelistPlayers.add("1c779cb1-3860-4e23-9cac-7f160b2acc61");
        bypassWhitelistPlayers.add("9227bb5d-1e46-4c84-85ee-8aafcd2dbd75");
        bypassWhitelistPlayers.add("9a2131e5-a07d-413e-ba0e-5344bcbcabf9");

        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static WhitelistManager getWhitelistManager() {
        return whitelistManager;
    }

    public static CubicNations getInstance() {
        return instance;
    }
}
