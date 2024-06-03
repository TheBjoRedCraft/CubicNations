package dev.thebjoredcraft.cubicnations.manager;

import dev.thebjoredcraft.craftcore.CraftCore;
import dev.thebjoredcraft.craftcore.manager.user.CCUser;
import dev.thebjoredcraft.cubicnations.CubicNations;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardManager {
    private BukkitRunnable runnable;
    public void update(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        if (scoreboard.getObjective("scoreboard_display") == null) {
            Objective objective = scoreboard.registerNewObjective("scoreboard_display", Criteria.DUMMY, MiniMessage.miniMessage().deserialize("<color:#24ff48><b>        Cubic Nations        </color>"));

            objective.getScore("§8 ").resetScore();
            objective.getScore("§7Restzeit: ").resetScore();
            objective.getScore("§b>> %restzeit%").resetScore();
            objective.getScore("§8 ").resetScore();
            objective.getScore("§7Spielzeit: ").resetScore();
            objective.getScore("§b>> " + CraftCore.getPlayTimeManager().getFormattedTime(new CCUser(player.getUniqueId().toString()))).resetScore();
            objective.getScore("§8 ").resetScore();
            objective.getScore("§7Universum: ").resetScore();
            objective.getScore("§b>> " + player.getWorld().getName()).resetScore();
            objective.getScore("§8 ").resetScore();

            objective.getScore("§8 ").setScore(10);
            objective.getScore("§7Restzeit: ").setScore(9);
            objective.getScore("§b>> %restzeit%").setScore(8);
            objective.getScore("§8 ").setScore(7);
            objective.getScore("§7Spielzeit: ").setScore(6);
            objective.getScore("§b>> " + CraftCore.getPlayTimeManager().getFormattedTime(new CCUser(player.getUniqueId().toString()))).setScore(5);
            objective.getScore("§8 ").setScore(4);
            objective.getScore("§7Universum: ").setScore(3);
            objective.getScore("§b>> " + player.getWorld().getName()).setScore(2);
            objective.getScore("§8 ").setScore(1);

            objective.setDisplaySlot(null);
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        }else{
            Objective objective = scoreboard.getObjective("scoreboard_display");

            objective.getScore("§8 ").resetScore();
            objective.getScore("§7Restzeit: ").resetScore();
            objective.getScore("§b>> %restzeit%").resetScore();
            objective.getScore("§9 ").resetScore();
            objective.getScore("§7Spielzeit: ").resetScore();
            objective.getScore("§b>> " + CraftCore.getPlayTimeManager().getFormattedTime(new CCUser(player.getUniqueId().toString()))).resetScore();
            objective.getScore("§2 ").resetScore();
            objective.getScore("§7Universum: ").resetScore();
            objective.getScore("§b>> " + player.getWorld().getName()).resetScore();
            objective.getScore("§3 ").resetScore();

            objective.getScore("§8 ").setScore(10);
            objective.getScore("§7Restzeit: ").setScore(9);
            objective.getScore("§b>> %restzeit%").setScore(8);
            objective.getScore("§9 ").setScore(7);
            objective.getScore("§7Spielzeit: ").setScore(6);
            objective.getScore("§b>> " + CraftCore.getPlayTimeManager().getFormattedTime(new CCUser(player.getUniqueId().toString()))).setScore(5);
            objective.getScore("§2 ").setScore(4);
            objective.getScore("§7Universum: ").setScore(3);
            objective.getScore("§b>> " + player.getWorld().getName()).setScore(2);
            objective.getScore("§3 ").setScore(1);

            objective.setDisplaySlot(null);
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        }
        player.setScoreboard(scoreboard);
    }
    public void start(){
        this.runnable = new BukkitRunnable() {
            @Override
            public void run() {
                for(Player player : Bukkit.getOnlinePlayers()){
                    update(player);
                }
            }
        };
        BukkitTask bukkitTask = this.runnable.runTaskTimer(CubicNations.getInstance(), 0, 20);
    }
    public void stop(){
        if(runnable != null){
            runnable.cancel();
        }
    }
}