package com.hanielcota.floruitclearlagg.config;

import com.hanielcota.floruitclearlagg.FloruitClearLagPlugin;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;

@Getter
public class PluginConfig {

    private final int clearIntervalTicks;
    private final int[] warningTimesTicks;
    private final String warningMessage;
    private final String clearMessage;
    private final String noItemsMessage;

    public PluginConfig(FloruitClearLagPlugin plugin) {
        FileConfiguration config = plugin.getConfig();

        this.clearIntervalTicks = config.getInt("clear-interval-seconds", 600) * 20; // Default: 10min
        this.warningTimesTicks = loadWarningTimes(config);
        this.warningMessage =
                config.getString("messages.warning", "§e[ClearLag] Items will be removed in {seconds} seconds!");
        this.clearMessage = config.getString("messages.clear", "§a[ClearLag] {amount} items were removed!");
        this.noItemsMessage = config.getString("messages.no-items", "§a[ClearLag] No items were found to remove!");
    }

    private int[] loadWarningTimes(FileConfiguration config) {
        return config.getIntegerList("warning-times-seconds").stream()
                .mapToInt(seconds -> seconds * 20)
                .toArray();
    }
}