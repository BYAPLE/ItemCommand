package de.keksgauner.itemcommand.listener;

import de.keksgauner.itemcommand.utils.Data;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class UseItemEvent implements Listener {

    @EventHandler
    public void onInteractEvent(PlayerInteractEvent event) {
        try {
        if (Data.getConfig().getConfig().getBoolean("name_and_type")) {
            if (event.getItem().getItemMeta().getDisplayName() == null) {
                return;
            }
            if (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', Data.getConfig().getConfig().getString("item.name"))) && Data.getConfig().getConfig().getBoolean("name_and_type")) {
                if (event.getItem().getType() == Material.getMaterial(Data.getConfig().getConfig().getString("item.type"))) {
                    event.setCancelled(true);
                }
            }
        } else {
            if (event.getItem().getType() == Material.getMaterial(Data.getConfig().getConfig().getString("item.type"))) {
                event.setCancelled(true);
            }
        }

        } catch (NullPointerException e) {

        }
    }
}
