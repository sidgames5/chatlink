package com.sidgames5.chatlink;

import com.sidgames5.chatlink.bot.Bot;
import com.sidgames5.chatlink.listeners.ChatListener;
import com.sidgames5.chatlink.listeners.PlayerEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

public final class Main extends JavaPlugin {
    private static final Logger logger = LoggerFactory.getLogger("ChatLink");
    public static final String VERSION = "1.0.1";

    @Override
    public void onEnable() {
        // Plugin startup logic
        logger.info("Starting ChatLink " + VERSION);

        logger.info("Loading config");
        PluginConfig.setup();
        PluginConfig.save();
        PluginConfig.getConfig().addDefault("BOT_TOKEN", "Place your bot token in here");
        PluginConfig.getConfig().addDefault("channelID", "Place your discord channel ID in here");
        PluginConfig.getConfig().addDefault("webhook", "Place your discord webhook URL in here");
        PluginConfig.save();
        logger.info("Config loaded");

        logger.info("Registering events");
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
        logger.info("Events registered");

        logger.info("Starting bot");
        try {
            Bot.run();
            logger.info("Bot started");
        } catch (LoginException e) {
            logger.error("Failed to start bot, is the token and channel ID set in config?", e);
        }

        logger.info("ChatLink is now started!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logger.info("Stopping ChatLink, goodbye!");

        PluginConfig.save();
        Bot.stop();

        logger.info("ChatLink stopped");
    }
}
