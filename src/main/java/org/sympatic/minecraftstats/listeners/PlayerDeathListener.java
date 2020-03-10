package org.sympatic.minecraftstats.listeners;

import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.sympatic.minecraftstats.MinecraftStats;
import org.sympatic.minecraftstats.file.ProfileFile;

@RequiredArgsConstructor
public class PlayerDeathListener implements Listener {

    private final MinecraftStats main;

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player victim = event.getEntity();
        Player killer = event.getEntity().getKiller();

        ProfileFile victimProfile = new ProfileFile(main, "/profiles", victim.getUniqueId().toString());
        victimProfile.setDeaths(victimProfile.getDeaths() + 1);
        victimProfile.save();

        if (killer != null) {
            ProfileFile killerProfile = new ProfileFile(main, "/profiles", killer.getUniqueId().toString());
            killerProfile.setKills(killerProfile.getKills() + 1);
            killerProfile.save();
        }
    }

}
