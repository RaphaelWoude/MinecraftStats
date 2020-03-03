package org.sympatic.minecraftstats.listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.sympatic.minecraftstats.MinecraftStats;
import org.sympatic.minecraftstats.file.ProfileFile;

public class PlayerBlockListener implements Listener {

    private MinecraftStats main;
    private FixedMetadataValue foundMeta;
    private FixedMetadataValue placedMeta;

    public PlayerBlockListener(MinecraftStats main) {
        this.main = main;
        this.foundMeta = new FixedMetadataValue(main, "FOUND");
        this.placedMeta = new FixedMetadataValue(main, "PLACED");
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        Block block = event.getBlockPlaced();

        switch (block.getType()){
            case NETHER_QUARTZ_ORE:
            case EMERALD_ORE:
            case DIAMOND_ORE:
            case REDSTONE_ORE:
            case LAPIS_ORE:
            case GOLD_ORE:
            case IRON_ORE:
            case COAL_ORE:
                block.setMetadata("PLACED", placedMeta);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        ProfileFile playerProfile = new ProfileFile(main, "/profiles", event.getPlayer().getUniqueId().toString());

        if (block.hasMetadata("PLACED")) return;

        switch (block.getType()) {
            case NETHER_QUARTZ_ORE:
                    block.setMetadata("FOUND", foundMeta);
                    playerProfile.setQuartz(playerProfile.getQuartz() + 1);
                    playerProfile.save();
                break;
            case EMERALD_ORE:
                if (!block.hasMetadata("FOUND")) {
                    block.setMetadata("FOUND", foundMeta);
                    playerProfile.setEmeralds(playerProfile.getEmeralds() + 1);
                    playerProfile.save();
                }
                break;
            case DIAMOND_ORE:
                if (!block.hasMetadata("FOUND")) {
                    block.setMetadata("FOUND", foundMeta);
                    playerProfile.setDiamonds(playerProfile.getDiamonds() + 1);
                    playerProfile.save();
                }
                break;
            case REDSTONE_ORE:
                if (!block.hasMetadata("FOUND")) {
                    block.setMetadata("FOUND", foundMeta);
                    playerProfile.setRedstone(playerProfile.getRedstone() + 1);
                    playerProfile.save();
                }
                break;
            case LAPIS_ORE:
                if (!block.hasMetadata("FOUND")) {
                    block.setMetadata("FOUND", foundMeta);
                    playerProfile.setLapis(playerProfile.getLapis() + 1);
                    playerProfile.save();
                }
                break;
            case GOLD_ORE:
                if (!block.hasMetadata("FOUND")) {
                    block.setMetadata("FOUND", foundMeta);
                    playerProfile.setGold(playerProfile.getGold() + 1);
                    playerProfile.save();
                }
                break;
            case IRON_ORE:
                if (!block.hasMetadata("FOUND")) {
                    block.setMetadata("FOUND", foundMeta);
                    playerProfile.setIron(playerProfile.getIron() + 1);
                    playerProfile.save();
                }
                break;
            case COAL_ORE:
                if (!block.hasMetadata("FOUND")) {
                    block.setMetadata("FOUND", foundMeta);
                    playerProfile.setCoal(playerProfile.getCoal() + 1);
                    playerProfile.save();
                }
                break;
        }
    }
}
