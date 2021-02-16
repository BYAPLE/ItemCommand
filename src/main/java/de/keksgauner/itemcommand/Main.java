package de.keksgauner.itemcommand;

import de.keksgauner.itemcommand.listener.*;
import de.keksgauner.itemcommand.utils.Data;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    public static Main getInstance() { return instance; }

    @Override
    public void onEnable() {
        instance = this;
        Data.init();

        Bukkit.getPluginManager().registerEvents(new ClickItemEvent(), this);

        if (Data.getConfig().getConfig().getBoolean("onJoin.enabled")) {
            Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        }

        if (Data.getConfig().getConfig().getBoolean("fixed")) {
            Bukkit.getPluginManager().registerEvents(new MoveItemEvent(), this);
        }

        if (!Data.getConfig().getConfig().getBoolean("throwable")) {
            Bukkit.getPluginManager().registerEvents(new DropItemEvent(), this);
        }

        if (!Data.getConfig().getConfig().getBoolean("use")) {
            Bukkit.getPluginManager().registerEvents(new UseItemEvent(), this);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
