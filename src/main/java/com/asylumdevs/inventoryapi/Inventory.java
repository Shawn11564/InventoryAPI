package com.asylumdevs.inventoryapi;

import org.bukkit.event.inventory.*;
import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;

public class Inventory
{
    private InventoryType inventoryType;
    private String inventoryName;
    private int inventorySlots;
    private HashMap<Integer, InventoryItem> slots;
    private org.bukkit.inventory.Inventory inv;
    
    public Inventory(final String name, final InventoryType type) {
        this.inventorySlots = 0;
        this.slots = new HashMap<Integer, InventoryItem>();
        this.inventoryName = name;
        this.inventoryType = type;
    }
    
    public Inventory(final String name, final int slots) {
        this.inventorySlots = 0;
        this.slots = new HashMap<Integer, InventoryItem>();
        this.inventoryName = name;
        this.inventorySlots = slots;
    }
    
    public void open(final Player player) {
        player.openInventory(this.getInventory());
    }
    
    public org.bukkit.inventory.Inventory getInventory() {
        if (this.inv == null) {
            if (this.inventorySlots != 0) {
                this.inv = Bukkit.createInventory((InventoryHolder)null, this.inventorySlots, ChatColor.translateAlternateColorCodes('&', this.inventoryName));
            }
            else {
                this.inv = Bukkit.createInventory((InventoryHolder)null, this.inventoryType, ChatColor.translateAlternateColorCodes('&', this.inventoryName));
            }
            for (int i = 0; i < 55; ++i) {
                if (this.slots.containsKey(i)) {
                    final InventoryItem item = this.slots.get(i);
                    this.inv.setItem(i, item.getItem());
                }
            }
        }
        return this.inv;
    }
    
    public InventoryType getType() {
        return this.inventoryType;
    }
    
    public String getName() {
        return this.inventoryName;
    }
    
    public void setSlot(final int slot, final ItemStack item, final ItemListener itemListener) {
        this.slots.put(slot, new InventoryItem(item, itemListener));
    }
    
    public InventoryItem getSlot(final int Slot) {
        return this.slots.get(Slot);
    }
}
