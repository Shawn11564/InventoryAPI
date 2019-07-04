package com.asylumdevs.inventoryapi;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import com.asylumdevs.inventoryapi.handlers.InventoryHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InventoryAPI extends JavaPlugin
{
    public static ArrayList<com.asylumdevs.inventoryapi.Inventory> inventories;
    
    static {
        InventoryAPI.inventories = new ArrayList<>();
    }
    
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents((Listener)new InventoryHandler(), (Plugin)this);
    }
    
    public static com.asylumdevs.inventoryapi.Inventory createInventory(final String name, final InventoryType type) {
        final com.asylumdevs.inventoryapi.Inventory inv = new com.asylumdevs.inventoryapi.Inventory(name, type);
        InventoryAPI.inventories.add(inv);
        return inv;
    }
    
    public static com.asylumdevs.inventoryapi.Inventory createInventory1(final String name, final int slots) {
        final com.asylumdevs.inventoryapi.Inventory inv = new Inventory(name, slots);
        InventoryAPI.inventories.add(inv);
        return inv;
    }
    
    public static ItemStack createItem(final String displayName, final List<String> description, final Material material, final Map<Enchantment, Integer> enchantments, final int amount) {
        final ItemStack item = new ItemStack(material);
        final ItemMeta itemMeta = item.getItemMeta();
        int i = 0;
        if (amount <= material.getMaxStackSize()) {
            item.setAmount(amount);
        }
        if (displayName != null) {
            itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));
        }
        try {
            if (description != null && description.size() != 0) {
                for (i = 0; i < description.size(); ++i) {
                    description.set(i, ChatColor.translateAlternateColorCodes('&', (String)description.get(i)));
                }
                itemMeta.setLore((List)description);
            }
        }
        catch (Exception ex) {}
        try {
            if (enchantments != null && enchantments.size() != 0) {
                item.addUnsafeEnchantments((Map)enchantments);
            }
        }
        catch (Exception ex2) {}
        item.setItemMeta(itemMeta);
        return item;
    }
    
    public static ItemStack createItem(final String displayName, final List<String> description, final ItemStack itemstack, final Map<Enchantment, Integer> enchantments, final int amount) {
        final ItemMeta itemMeta = itemstack.getItemMeta();
        int i = 0;
        if (amount <= itemstack.getMaxStackSize()) {
            itemstack.setAmount(amount);
        }
        if (displayName != null) {
            itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));
        }
        try {
            if (description != null && description.size() != 0) {
                for (i = 0; i < description.size(); ++i) {
                    description.set(i, ChatColor.translateAlternateColorCodes('&', (String)description.get(i)));
                }
                itemMeta.setLore((List)description);
            }
        }
        catch (Exception ex) {}
        try {
            if (enchantments != null && enchantments.size() != 0) {
                itemstack.addUnsafeEnchantments((Map)enchantments);
            }
        }
        catch (Exception ex2) {}
        itemstack.setItemMeta(itemMeta);
        return itemstack;
    }
}
