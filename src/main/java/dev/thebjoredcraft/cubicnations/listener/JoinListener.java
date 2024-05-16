package dev.thebjoredcraft.cubicnations.listener;

import dev.thebjoredcraft.cubicnations.CubicNations;
import dev.thebjoredcraft.cubicnations.utils.Message;
import dev.thebjoredcraft.cubicnations.utils.user.CNPlayerWhitelistInformation;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerLoginEvent event) {

        Player player = event.getPlayer();

        if(!CubicNations.bypassWhitelistPlayers.contains(player.getUniqueId().toString())) {
            if (!new CNPlayerWhitelistInformation(player.getName()).isBanned()) {
                if (CubicNations.started) {
                    if (!CubicNations.getWhitelistManager().isWhitelisted(player.getName())) {
                        event.setResult(PlayerLoginEvent.Result.KICK_OTHER);
                        event.kickMessage(MiniMessage.miniMessage().deserialize(Message.WHITELIST_NOT_WHITELISTED));
                    }
                } else {
                    event.setResult(PlayerLoginEvent.Result.KICK_OTHER);
                    event.kickMessage(MiniMessage.miniMessage().deserialize(Message.WHITELIST_PROJECT_NOT_STARTED));
                }
            } else {
                event.setResult(PlayerLoginEvent.Result.KICK_BANNED);
                event.kickMessage(MiniMessage.miniMessage().deserialize(Message.WHITELIST_BANNED));
            }
        }
    }
}
