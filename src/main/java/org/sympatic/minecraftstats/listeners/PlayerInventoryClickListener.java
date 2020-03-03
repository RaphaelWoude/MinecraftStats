package org.sympatic.minecraftstats.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PlayerInventoryClickListener implements Listener {

    @EventHandler
    public void onInteract(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (player.getOpenInventory().getTitle().equals(ChatColor.BLUE + ChatColor.BOLD.toString() + "Stats")) {
            event.setCancelled(true);
        }
    }
}
