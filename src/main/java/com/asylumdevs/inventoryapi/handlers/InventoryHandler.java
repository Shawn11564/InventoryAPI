package com.asylumdevs.inventoryapi.handlers;

import com.asylumdevs.inventoryapi.Inventory;
import com.asylumdevs.inventoryapi.InventoryAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryHandler implements Listener
{
    @EventHandler
    public void onInvClick(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        for (final Inventory invs : InventoryAPI.inventories) {
            if (invs.getInventory().equals(e.getClickedInventory())) {
                if (e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY || e.getAction() == InventoryAction.COLLECT_TO_CURSOR) {
                    e.setCancelled(true);
                }
                e.setCancelled(true);
                try {
                    final int slot = e.getSlot();
                    invs.getSlot(slot).getItemListener().onItemClick(p, e.getClick());
                }
                catch (Exception ex) {}
            }
        }
    }
}
