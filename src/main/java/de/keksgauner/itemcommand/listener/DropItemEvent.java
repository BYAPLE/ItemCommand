package de.keksgauner.itemcommand.listener;

import de.keksgauner.itemcommand.utils.Data;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropItemEvent implements Listener {

    @EventHandler
    public void onDropItemEvent(PlayerDropItemEvent event) {
        if (Data.getConfig().getConfig().getBoolean("name_and_type")) {
            if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName() == null) {
                return;
            }
            if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', Data.getConfig().getConfig().getString("item.name"))) && Data.getConfig().getConfig().getBoolean("name_and_type")) {
                if (event.getItemDrop().getItemStack().getType() == Material.getMaterial(Data.getConfig().getConfig().getString("item.type"))) {
                    event.setCancelled(true);
                }
            }
        } else {
            if (event.getItemDrop().getItemStack().getType() == Material.getMaterial(Data.getConfig().getConfig().getString("item.type"))) {
                event.setCancelled(true);
            }
        }
    }

}
