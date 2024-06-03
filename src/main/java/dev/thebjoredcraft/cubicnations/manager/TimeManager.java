package dev.thebjoredcraft.cubicnations.manager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.time.LocalTime;

public class TimeManager {
    public void checkTime(){
        LocalTime now = LocalTime.now();
        LocalTime start = LocalTime.of(11, 17);
        LocalTime end = LocalTime.of(11, 20);
        File ccWhitelistFile = new File("/plugins/CraftCore/whitelist.yml");
        FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(ccWhitelistFile);

        if (now.isAfter(start) || now.isBefore(end)) {
            fileConfiguration.set("enabled", true);
        } else {
            fileConfiguration.set("enabled", false);
        }
    }
}
