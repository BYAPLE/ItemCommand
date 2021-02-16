package de.keksgauner.itemcommand.listener;

import de.keksgauner.itemcommand.Main;
import de.keksgauner.itemcommand.utils.Data;
import de.keksgauner.itemcommand.utils.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if(Data.getConfig().getConfig().getBoolean("old.enabled")) {
            Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), () -> event.getPlayer().getInventory().setItem(Data.getConfig().getConfig().getInt("onJoin.slot"), ItemManager.createItemWithMaterialWithSubid(Material.getMaterial(Data.getConfig().getConfig().getString("item.type")), Data.getConfig().getConfig().getInt("item.amount"), Data.getConfig().getConfig().getInt("old.id"), ChatColor.translateAlternateColorCodes('&', Data.getConfig().getConfig().getString("item.name")))));
        } else {
            Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), () -> event.getPlayer().getInventory().setItem(Data.getConfig().getConfig().getInt("onJoin.slot"), ItemManager.createItemWithMaterial(Material.getMaterial(Data.getConfig().getConfig().getString("item.type")), Data.getConfig().getConfig().getInt("item.amount"), ChatColor.translateAlternateColorCodes('&', Data.getConfig().getConfig().getString("item.name")))));
        }
    }
}
