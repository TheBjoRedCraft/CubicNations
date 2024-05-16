package dev.thebjoredcraft.cubicnations.manager;

import dev.thebjoredcraft.cubicnations.utils.user.CNPlayerWhitelistInformation;

public class WhitelistManager {
    public void whitelist(String playername){

    }
    public boolean isWhitelisted(String playername){
        return new CNPlayerWhitelistInformation(playername).isWhitelisted();
    }
}
