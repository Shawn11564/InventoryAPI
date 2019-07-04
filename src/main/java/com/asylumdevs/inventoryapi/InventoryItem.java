package com.asylumdevs.inventoryapi;

import org.bukkit.inventory.*;

public class InventoryItem
{
    private ItemStack item;
    private ItemListener itemListener;
    
    public InventoryItem(final ItemStack item, final ItemListener itemListener) {
        this.item = item;
        this.itemListener = itemListener;
    }
    
    public ItemStack getItem() {
        return this.item;
    }
    
    public ItemListener getItemListener() {
        return this.itemListener;
    }
}
