package de.keksgauner.itemcommand.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * @author KeksGauner
 * by ByAple Opensorce
 */
public class ItemManager {

    public static ItemStack createItemWithMaterialWithSubid(Material material, int anzahl, int subid, String displayname) {

        ItemStack i = new ItemStack(material, anzahl, (short) subid);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName(displayname);
        i.setItemMeta(m);

        return i;
    }

    public static ItemStack createItemWithMaterial(Material material, int anzahl, String displayname) {
        ItemStack i = new ItemStack(material, anzahl);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName(displayname);
        i.setItemMeta(m);

        return i;
    }
}
