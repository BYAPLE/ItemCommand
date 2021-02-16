package de.keksgauner.itemcommand.utils;

import de.keksgauner.itemcommand.Main;
import de.keksgauner.itemcommand.api.ConfigAccessor;

public class Data {
    private static final ConfigAccessor config = new ConfigAccessor(Main.getInstance(), "config.yml");
    public static final ConfigAccessor getConfig() {return config;}

    public static void init() {
        getConfig().saveDefaultConfig();
        getConfig().getConfig().options().copyDefaults(true);
        getConfig().saveConfig();
    }
}
