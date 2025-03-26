package com.hanielcota.floruitclearlagg.service;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;

public class ItemClearService {

    public int clearDroppedItems() {
        int count = 0;

        for (World world : Bukkit.getWorlds()) {
            count += clearItemsInWorld(world);
        }

        return count;
    }

    private int clearItemsInWorld(World world) {
        int count = 0;

        for (Entity entity : world.getEntities()) {
            if (!(entity instanceof Item)) continue;

            entity.remove();
            count++;
        }

        return count;
    }
}