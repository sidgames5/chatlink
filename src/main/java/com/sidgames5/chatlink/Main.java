package com.sidgames5.chatlink;

import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Main extends JavaPlugin {
    private static final Logger logger = LoggerFactory.getLogger("ChatLink");
    public static final String VERSION = "1.0.0-alpha.1+bukkit";

    @Override
    public void onEnable() {
        // Plugin startup logic
        logger.info("Starting ChatLink " + VERSION);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logger.info("Stopping ChatLink, goodbye!");
    }
}
