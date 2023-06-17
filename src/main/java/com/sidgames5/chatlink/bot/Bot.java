package com.sidgames5.chatlink.bot;

import com.sidgames5.chatlink.Secrets;
import com.sidgames5.chatlink.bot.event.MessageEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

import java.util.ArrayList;
import java.util.Collection;

import static com.sidgames5.chatlink.ChatLink.LOGGER;

public class Bot {
    public static JDA bot;

    public static void run() throws LoginException {
        LOGGER.info("Starting bot");

        Collection<GatewayIntent> intents = new ArrayList<>();
        intents.add(GatewayIntent.GUILD_MEMBERS);
        intents.add(GatewayIntent.GUILD_MESSAGES);

        bot = JDABuilder.create(Secrets.getFromConfig("BOT_TOKEN"), intents)
                .setActivity(Activity.playing("Minecraft"))
                .build();

        bot.addEventListener(new MessageEvent());

        LOGGER.info("Bot started!");
    }

    public static void stop() {
        bot.shutdown();
    }

    public static void sendToDiscord(String sender, String message) {
        String messageFormatted = "<" + sender + "> " + message;
    }
}
