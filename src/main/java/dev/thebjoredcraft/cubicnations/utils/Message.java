package dev.thebjoredcraft.cubicnations.utils;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

public class Message {
    public static String prefix = "<gray>>> <color:#40d1db>CN <gray>| <color:#3b92d1>";

    public static void send(Player player, String  message){
        player.sendMessage(MiniMessage.miniMessage().deserialize(prefix + message));
    }
    public static void sendRaw(Player player, String  message){
        player.sendMessage(MiniMessage.miniMessage().deserialize(message));
    }
    //messages


    public static String WHITELIST_PROJECT_NOT_STARTED = "<red><bold>Das Projekt hat noch nicht gestartet!";
    public static String WHITELIST_NOT_WHITELISTED = "<red><bold>Du bist nicht gewhitelisted! \n Du kannst dich in unserem Discord whitelisten lassen!";
    public static String WHITELIST_BANNED = "<red><bold>Du bist gebannt! \n Du kannst einen Entbannungsantrag in unserem Discord stellen!";
}
