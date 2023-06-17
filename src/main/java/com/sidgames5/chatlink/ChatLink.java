package com.sidgames5.chatlink;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import com.netherbyte.svlib.Version;
import com.sidgames5.chatlink.bot.Bot;
import net.fabricmc.api.ModInitializer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

public class ChatLink implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("ChatLink");
	public static final Version VERSION = new Version("1.0.0-SNAPSHOT.1");

	@Override
	public void onInitialize() {
		LOGGER.info("Starting ChatLink " + VERSION.getFormattedName());

		try {
			Bot.run();
		} catch (LoginException e) {
			throw new RuntimeException(e);
		}
	}

	public static void sendMessage(String message) {

	}


}