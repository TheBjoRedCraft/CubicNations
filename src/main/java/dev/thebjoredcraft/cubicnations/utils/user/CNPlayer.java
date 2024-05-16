package dev.thebjoredcraft.cubicnations.utils.user;

import org.bukkit.OfflinePlayer;

public class CNPlayer {
    public OfflinePlayer player;

    public CNPlayer(OfflinePlayer player){
        this.player = player;
    }

    public CNPlayerWhitelistInformation getCNPlayerWhitelistInformation() {
        return new CNPlayerWhitelistInformation(player.getName());
    }
}
