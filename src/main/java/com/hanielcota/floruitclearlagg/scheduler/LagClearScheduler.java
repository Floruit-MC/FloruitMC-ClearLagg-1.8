package com.hanielcota.floruitclearlagg.scheduler;

import com.hanielcota.floruitclearlagg.FloruitClearLagPlugin;
import com.hanielcota.floruitclearlagg.service.ItemClearService;
import com.hanielcota.floruitclearlagg.util.BroadcastUtil;
import org.bukkit.scheduler.BukkitRunnable;

public class LagClearScheduler {

    private final FloruitClearLagPlugin plugin;
    private final ItemClearService itemClearService;

    public LagClearScheduler(FloruitClearLagPlugin plugin) {
        this.plugin = plugin;
        this.itemClearService = new ItemClearService();
    }

    public void start() {
        new BukkitRunnable() {
            @Override
            public void run() {
                scheduleWarnings();
                scheduleClear();
            }
        }.runTaskTimerAsynchronously(plugin, 0L, plugin.getPluginConfig().getClearIntervalTicks());
    }

    private void scheduleWarnings() {
        int[] warningTimes = plugin.getPluginConfig().getWarningTimesTicks();

        for (int time : warningTimes) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    sendWarning(time / 20); // Converte ticks para segundos
                }
            }.runTaskLaterAsynchronously(plugin, plugin.getPluginConfig().getClearIntervalTicks() - time);
        }
    }

    private void sendWarning(int secondsLeft) {
        String message = plugin.getPluginConfig().getWarningMessage().replace("{seconds}", String.valueOf(secondsLeft));
        BroadcastUtil.sendMessage(message);
    }

    private void scheduleClear() {
        new BukkitRunnable() {
            @Override
            public void run() {
                int removedItems = itemClearService.clearDroppedItems();
                announceResult(removedItems);
            }
        }.runTaskLater(plugin, plugin.getPluginConfig().getClearIntervalTicks());
    }

    private void announceResult(int amount) {
        if (amount == 0) {
            BroadcastUtil.sendMessage(plugin.getPluginConfig().getNoItemsMessage());
            return;
        }

        String message = plugin.getPluginConfig().getClearMessage().replace("{amount}", String.valueOf(amount));
        BroadcastUtil.sendMessage(message);
    }
}