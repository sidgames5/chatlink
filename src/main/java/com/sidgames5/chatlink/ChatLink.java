package com.sidgames5.chatlink;

import com.netherbyte.svlib.Version;
import com.sidgames5.chatlink.bot.Bot;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerTask;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

import static net.minecraft.server.command.CommandManager.literal;

public class ChatLink implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("ChatLink");
	public static final Version VERSION = new Version("1.0.0");

	private static MinecraftServer server;

	@Override
	public void onInitialize() {
		LOGGER.info("Starting ChatLink " + VERSION.getFormattedName());

		try {
			Bot.run();
		} catch (LoginException e) {
			throw new RuntimeException(e);
		}

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("linkdiscord")
				.executes(context -> {
					server = context.getSource().getServer();
					return 1;
				})));


	}

	public static void sendMessage(String sender, String message) {
		if (server != null) {
			server.sendMessage(Text.literal("[DISCORD: " + sender + "] " + message));
		}
	}
}