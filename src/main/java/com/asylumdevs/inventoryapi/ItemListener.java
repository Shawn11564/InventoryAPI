package com.asylumdevs.inventoryapi;

import org.bukkit.entity.*;
import org.bukkit.event.inventory.*;

public abstract class ItemListener
{
    public abstract void onItemClick(final Player p0, final ClickType p1);
}
