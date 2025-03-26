package com.hanielcota.floruitclearlagg;

import com.hanielcota.floruitclearlagg.config.PluginConfig;
import com.hanielcota.floruitclearlagg.scheduler.LagClearScheduler;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class FloruitClearLagPlugin extends JavaPlugin {

    private PluginConfig pluginConfig;
    private LagClearScheduler scheduler;

    @Override
    public void onEnable() {
        initializeConfig();
        startScheduler();
        getLogger().info("FloruitClearLag plugin enabled successfully!");
    }

    private void initializeConfig() {
        saveDefaultConfig();
        pluginConfig = new PluginConfig(this);
    }

    private void startScheduler() {
        scheduler = new LagClearScheduler(this);
        scheduler.start();
    }

    @Override
    public void onDisable() {
        getLogger().info("FloruitClearLag plugin disabled!");
    }
}