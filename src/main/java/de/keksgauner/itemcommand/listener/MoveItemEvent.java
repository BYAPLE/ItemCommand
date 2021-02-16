package de.keksgauner.itemcommand.listener;

import de.keksgauner.itemcommand.utils.Data;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MoveItemEvent implements Listener {

    @EventHandler
    public void onClickEvent(InventoryClickEvent event) {
        try {
            if (Data.getConfig().getConfig().getBoolean("name_and_type")) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', Data.getConfig().getConfig().getString("item.name"))) && Data.getConfig().getConfig().getBoolean("name_and_type")) {
                    if (event.getCurrentItem().getType() == Material.getMaterial(Data.getConfig().getConfig().getString("item.type"))) {
                        event.setCancelled(true);
                    }
                }
            } else {
                if (event.getCurrentItem().getType() == Material.getMaterial(Data.getConfig().getConfig().getString("item.type"))) {
                    event.setCancelled(true);
                }
            }
        } catch (NullPointerException e) {

        }
    }
}
