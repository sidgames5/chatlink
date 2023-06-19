package com.sidgames5.chatlink;

import com.sidgames5.chatlink.listeners.ChatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Main extends JavaPlugin {
    private static final Logger logger = LoggerFactory.getLogger("ChatLink");
    public static final String VERSION = "1.0.0+bukkit";

    @Override
    public void onEnable() {
        // Plugin startup logic
        logger.info("Starting ChatLink " + VERSION);

        logger.info("Loading config");
        PluginConfig.setup();
        PluginConfig.save();
        PluginConfig.getConfig().addDefault("botToken", "Place your bot token in here");
        PluginConfig.getConfig().addDefault("channelID", "Place your discord channel ID in here");
        PluginConfig.save();
        logger.info("Config loaded");

        logger.info("Registering events");
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        logger.info("Events registered");

        logger.info("ChatLink is now setup!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logger.info("Stopping ChatLink, goodbye!");

        PluginConfig.save();

        logger.info("ChatLink stopped");
    }
}
