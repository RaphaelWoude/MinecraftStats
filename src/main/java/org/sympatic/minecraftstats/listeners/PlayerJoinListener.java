package org.sympatic.minecraftstats.listeners;

import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.sympatic.minecraftstats.MinecraftStats;
import org.sympatic.minecraftstats.file.ProfileFile;

@RequiredArgsConstructor
public class PlayerJoinListener implements Listener {

    private final MinecraftStats main;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        ProfileFile playerProfile = new ProfileFile(main, "/profiles", player.getUniqueId().toString());
        playerProfile.generateDefaults();
        playerProfile.save();
    }
}
