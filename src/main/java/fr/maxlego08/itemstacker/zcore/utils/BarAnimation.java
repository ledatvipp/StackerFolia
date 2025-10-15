package fr.maxlego08.itemstacker.zcore.utils;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.tcoded.folialib.wrapper.task.WrappedTask;

import fr.maxlego08.itemstacker.zcore.ZPlugin;

import java.util.List;

/**
 * Creates and manages a smooth BossBar animation for a group of players.
 */
public class BarAnimation {

    private final BossBar bossBar;
    private final double totalTime;
    private double remainingTime;
    private final WrappedTask task;

    /**
     * Creates a new smooth BossBar animation for a group of players.
     *
     * @param players  the list of players to display the BossBar to.
     * @param text     the text to display on the BossBar.
     * @param seconds  the total duration of the animation in seconds.
     * @param barColor the color of the BossBar.
     * @param barStyle the style of the BossBar.
     */
    public BarAnimation(List<Player> players, String text, int seconds, BarColor barColor, BarStyle barStyle) {
        this.bossBar = Bukkit.createBossBar(text, barColor, barStyle);
        this.totalTime = seconds * 20.0; // Convert seconds to ticks (20 ticks = 1 second)
        this.remainingTime = totalTime;

        for (Player player : players) {
            this.bossBar.addPlayer(player);
        }

        this.bossBar.setVisible(true);
        ZPlugin plugin = (ZPlugin) JavaPlugin.getProvidingPlugin(getClass());
        this.task = plugin.getScheduler().runTimer(this::tick, 0L, 1L);
    }

    private void tick() {
        double progress = remainingTime / totalTime;
        bossBar.setProgress(progress);

        if (remainingTime <= 0) {
            bossBar.removeAll();
            task.cancel(); // Stop the task when the BossBar is empty
        }

        remainingTime -= 1; // Decrease by 1 tick at each update
    }
}
