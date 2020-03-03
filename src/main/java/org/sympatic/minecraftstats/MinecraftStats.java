package org.sympatic.minecraftstats;

import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.sympatic.minecraftstats.commands.StatsCommand;
import org.sympatic.minecraftstats.file.ProfileFile;
import org.sympatic.minecraftstats.listeners.PlayerBlockListener;
import org.sympatic.minecraftstats.listeners.PlayerDeathListener;
import org.sympatic.minecraftstats.listeners.PlayerInventoryClickListener;
import org.sympatic.minecraftstats.listeners.PlayerJoinListener;

/**
 * Minecraft Stats Plugin.
 * Version 1.15.2.
 * Created by Sympatic.
 */
public class MinecraftStats extends JavaPlugin {

    private static MinecraftStats main;

    @Override
    public void onEnable() {
        main = this;

        registerListeners();
        registersCommands();

        getServer().getScheduler().runTaskTimer(this, () -> {
            for (Player player : getServer().getOnlinePlayers()) {
                ProfileFile playerProfile = new ProfileFile(main, "/profiles", player.getUniqueId().toString());
                playerProfile.setPlaytime(playerProfile.getPlaytime() + 5);
                playerProfile.save();
            }
        }, 20, 20 * 5);
    }

    @Override
    public void onDisable() {
        main = null;
    }

    private void registersCommands() {
        getCommand("stats").setExecutor(new StatsCommand(this));
    }

    private void registerListeners() {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerJoinListener(this), this);
        pluginManager.registerEvents(new PlayerDeathListener(this), this);
        pluginManager.registerEvents(new PlayerInventoryClickListener(), this);
        pluginManager.registerEvents(new PlayerBlockListener(this), this);
    }

}
