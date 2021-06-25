package de.dasanten.randomgames.spawnItems;

import de.dasanten.randomgames.RandomGames;
import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class SpawnItemsTask extends TimerTask {

    @Override
    public void run() {
        Server server = Bukkit.getServer();
        server.getOnlinePlayers().forEach(player -> {
            int pick = new Random().nextInt(Material.values().length);
            Material material = Material.values()[pick];
            ItemStack itemStack = new ItemStack(material, 64);
            ItemMeta itemMeta = itemStack.getItemMeta();
            List<String> name = new ArrayList<>();
            name.add(player.getName());
            assert itemMeta != null;
            itemMeta.setLore(name);
            itemStack.setItemMeta(itemMeta);
            player.sendMessage(ChatColor.GREEN + "Neue Items sind gedroppt!");
            Bukkit.getScheduler().callSyncMethod(RandomGames.plugin, () ->
                player.getWorld().dropItemNaturally(player.getLocation(), itemStack)
            );
        });

    }
}
