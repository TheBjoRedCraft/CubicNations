package dev.thebjoredcraft.cubicnations.manager;

import dev.thebjoredcraft.cubicnations.CubicNations;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Runnable {
    private BukkitRunnable runnable;
    private final JavaPlugin instance;

    public Runnable(JavaPlugin instance){
        this.instance = instance;
    }

    public void start(){
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                CubicNations.getTimeManager().checkTime();
            }
        };
        BukkitTask bukkitTask = runnable.runTaskTimer(instance, 0, 20);
    }

    public void stop(){
        if(runnable != null){
            runnable.cancel();
        }
    }
}
