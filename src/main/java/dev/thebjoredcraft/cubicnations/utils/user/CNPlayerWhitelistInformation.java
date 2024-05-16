package dev.thebjoredcraft.cubicnations.utils.user;

import dev.thebjoredcraft.cubicnations.utils.database.SQL;

public class CNPlayerWhitelistInformation {
    public String playername;

    public CNPlayerWhitelistInformation(String playername){
        this.playername = playername;
    }
    public boolean isBanned(){
        if(SQL.get("banned", "mc_name", "=", playername, "cubic_nations_whitelist").equals(1)){
            return true;
        }else{
            return false;
        }
    }
    public boolean isWhitelisted(){
        return SQL.exists("mc_name", playername, "cubic_nations_whitelist");
    }
    public int getDiscordID(){
        return (int) SQL.get("dc_id", "mc_name", "=", playername, "cubic_nations_whitelist");
    }
    public String getDiscordName(){
        return (String) SQL.get("dc_name", "mc_name", "=", playername, "cubic_nations_whitelist");
    }
}
