package com.sidgames5.chatlink;

import com.sidgames5.chatlink.bot.Bot;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;

public class ChatLink implements ModInitializer {
    private static final Logger logger = LoggerFactory.getLogger(ChatLink.class);
    public static final String VERSION = FabricLoader.getInstance().getModContainer("chatlink").orElseThrow().getMetadata().getVersion().getFriendlyString();

    @Override
    public void onInitialize() {
        logger.info("Starting ChatLink " + VERSION);

        ServerLifecycleEvents.SERVER_STARTED.register(MinecraftServerAccessor::setServer);

        logger.info("Loading config");
        try {
            ConfigManager.init();
            ConfigManager.load();

            logger.info("Configuring bot");
            Bot.configure(Config.webhookURL, new MinecraftServerAccessor(), Config.channelID);
            logger.info("Starting bot");
            try {
                Bot.run(Config.botToken);

                logger.info("Started ChatLink " + VERSION);
            } catch (LoginException e) {
                logger.error("Failed to start bot", e);
            }
        } catch (IOException e) {
            logger.error("Failed to load config", e);
        }

        ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
            logger.info("Shutting down ChatLink");

            logger.info("Stopping bot");
            Bot.stop();

            logger.info("Stopped ChatLink");
        });
    }
}
