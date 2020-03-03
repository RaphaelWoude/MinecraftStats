package org.sympatic.minecraftstats.file;

import lombok.Getter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.sympatic.minecraftstats.MinecraftStats;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public abstract class AbstractFile {

    private final MinecraftStats minecraftStats;

    @Getter
    private File file, dir;

    @Getter
    private YamlConfiguration config;

    public AbstractFile(MinecraftStats minecraftStats, String directory, String fileName) {
        this.minecraftStats = minecraftStats;
        this.dir = minecraftStats.getDataFolder();

        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                minecraftStats.getLogger().log(Level.WARNING, "Could not create data folder for plugin.");
            }
        }

        this.dir = new File(minecraftStats.getDataFolder() + "/" + directory);

        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                minecraftStats.getLogger().log(Level.WARNING, "Could not create data folder for plugin.");
            }
        }

        this.file = new File(minecraftStats.getDataFolder() + "/" + directory, fileName);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        config = new YamlConfiguration();

        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
