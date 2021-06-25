package de.dasanten.randomgames.spawnItems;

import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class SpawnItemsEventHandler implements Listener {

    @EventHandler
    public void EntityPickupItemEvent(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            ItemStack itemStack = event.getItem().getItemStack();
            if(itemStack.getItemMeta() == null || itemStack.getItemMeta().getLore() == null ||
                    !event.getItem().getItemStack().getItemMeta().getLore().contains(player.getName())) {
                event.setCancelled(true);
            }
        }


    }

}
