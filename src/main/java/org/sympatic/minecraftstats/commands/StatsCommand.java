package org.sympatic.minecraftstats.commands;

import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.sympatic.minecraftstats.MinecraftStats;
import org.sympatic.minecraftstats.file.ProfileFile;
import org.sympatic.minecraftstats.utils.TimeUtil;
import org.sympatic.minecraftstats.utils.UUIDFetcher;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class StatsCommand implements CommandExecutor {

    private final MinecraftStats main;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        switch (args.length) {
            case 1:
                Player player = (Player) sender;
                UUID uuid;
                try {
                    uuid = UUIDFetcher.getUUIDOf(args[0]);
                } catch (Exception e) {
                    sender.sendMessage(ChatColor.RED + "Error: Could not find player: " + args[0]);
                    break;
                }

                if (uuid == null) {
                    sender.sendMessage(ChatColor.RED + "Error: Could not find player: " + args[0]);
                    break;
                }

                OfflinePlayer offlinePlayer = main.getServer().getOfflinePlayer(uuid);

                if (!offlinePlayer.hasPlayedBefore()) {
                    sender.sendMessage(ChatColor.RED + "Error: Player " + args[0] + " has not played on this server.");
                    break;
                }

                ProfileFile playerProfile = new ProfileFile(main, "/profiles", offlinePlayer.getUniqueId().toString());
                Inventory inventory = main.getServer().createInventory(null, 9 * 4, ChatColor.BLUE + ChatColor.BOLD.toString() + "Stats");
                inventory.setItem(13, addPlayerHead(offlinePlayer));
                inventory.setItem(21, addPvpItem(playerProfile));
                inventory.setItem(22, addOresItem(playerProfile));
                inventory.setItem(23, addPlaytimeItem(playerProfile));
                player.openInventory(inventory);
                break;
            case 0:
            default:
                sender.sendMessage(ChatColor.RED + "Usage: /stats <player>");
                break;
        }

        return true;
    }

    private ItemStack addPlayerHead(OfflinePlayer offlinePlayer) {
        ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skull = (SkullMeta) itemStack.getItemMeta();

        LinkedList<String> lores = new LinkedList<>();
        lores.add(ChatColor.GRAY + "(" + offlinePlayer.getUniqueId().toString() + ")");
        skull.setLore(lores);

        skull.setOwningPlayer(offlinePlayer);
        skull.setDisplayName(ChatColor.GOLD + ChatColor.BOLD.toString() + offlinePlayer.getName());
        itemStack.setItemMeta(skull);

        return itemStack;
    }

    private ItemStack addPvpItem(ProfileFile profileFile) {
        ItemStack itemStack = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta itemMeta = itemStack.getItemMeta();
        LinkedList<String> lores = new LinkedList<>();
        lores.add(ChatColor.GRAY + "Kills: " + ChatColor.WHITE + profileFile.getKills());
        lores.add(ChatColor.GRAY + "Deaths: " + ChatColor.WHITE + profileFile.getDeaths());
        itemMeta.setLore(lores);
        itemMeta.setDisplayName(ChatColor.WHITE + ChatColor.BOLD.toString() + "Combat");
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    private ItemStack addOresItem(ProfileFile profileFile) {
        ItemStack itemStack = new ItemStack(Material.DIAMOND_ORE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        LinkedList<String> lores = new LinkedList<>();
        lores.add(ChatColor.GRAY + "Quartz ore: " + ChatColor.WHITE + profileFile.getQuartz());
        lores.add(ChatColor.GRAY + "Emerald ore: " + ChatColor.WHITE + profileFile.getEmeralds());
        lores.add(ChatColor.GRAY + "Diamond ore: " + ChatColor.WHITE + profileFile.getDiamonds());
        lores.add(ChatColor.GRAY + "Redstone ore: " + ChatColor.WHITE + profileFile.getRedstone());
        lores.add(ChatColor.GRAY + "Lapis ore: " + ChatColor.WHITE + profileFile.getLapis());
        lores.add(ChatColor.GRAY + "Gold ore: " + ChatColor.WHITE + profileFile.getGold());
        lores.add(ChatColor.GRAY + "Iron ore: " + ChatColor.WHITE + profileFile.getIron());
        lores.add(ChatColor.GRAY + "Coal ore: " + ChatColor.WHITE + profileFile.getCoal());
        itemMeta.setLore(lores);
        itemMeta.setDisplayName(ChatColor.WHITE + ChatColor.BOLD.toString() + "Ores");
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    private ItemStack addPlaytimeItem(ProfileFile profileFile) {
        ItemStack itemStack = new ItemStack(Material.CLOCK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        LinkedList<String> lores = new LinkedList<>();
        lores.add(ChatColor.GRAY + TimeUtil.convert(profileFile.getPlaytime()));
        itemMeta.setLore(lores);
        itemMeta.setDisplayName(ChatColor.WHITE + ChatColor.BOLD.toString() + "Playtime");
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

}
