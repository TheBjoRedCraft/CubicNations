package dev.thebjoredcraft.cubicnations;

import dev.thebjoredcraft.craftcore.CraftCore;
import dev.thebjoredcraft.cubicnations.manager.Runnable;
import dev.thebjoredcraft.cubicnations.manager.ScoreboardManager;
import dev.thebjoredcraft.cubicnations.manager.TimeManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class CubicNations extends JavaPlugin {
    public static CubicNations instance;
    public static TimeManager timeManager;
    public static ScoreboardManager scoreboardManager;
    public static Runnable runnable;
    public static CraftCore craftCore;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        runnable = new Runnable(this);
        timeManager = new TimeManager();
        scoreboardManager = new ScoreboardManager();

        CubicNations.getRunnable().start();
        CubicNations.getScoreboardManager().start();
        CubicNations.craftCore = CraftCore.getInstance();

        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        CubicNations.getRunnable().stop();
        CubicNations.getScoreboardManager().stop();
        // Plugin shutdown logic
    }

    public static CubicNations getInstance() {
        return instance;
    }

    public static Runnable getRunnable() {
        return runnable;
    }

    public static TimeManager getTimeManager() {
        return timeManager;
    }

    public static CraftCore getCraftCoreInstance() {
        return craftCore;
    }

    public static ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }
}
