package com.sidgames5.chatlink.bot.event;

import com.sidgames5.chatlink.MessageUtil;
import com.sidgames5.chatlink.PluginConfig;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageEvents extends ListenerAdapter {
    private static final Logger logger = LoggerFactory.getLogger("ChatLink Bot");
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String sender = event.getMessage().getAuthor().getName();
        String message = event.getMessage().getContentRaw();
        //logger.info("[DISCORD: " + sender + "] " + message);
        if (!event.getMessage().getAuthor().isBot() && event.getMessage().getChannel().getId().equals(PluginConfig.get("channelID"))) Bukkit.getServer().broadcastMessage("[DISCORD: " + sender + "] " + MessageUtil.replaceIDwithUsername(message));
    }
    public void onGuildMessageUpdates(GuildMessageUpdateEvent event) {
        String sender = event.getMessage().getAuthor().getName();
        String message = event.getMessage().getContentRaw();
        logger.info("edit message: " + message);
        //logger.info("[DISCORD: " + sender + "] (Edited) " + message);
        if (!event.getMessage().getAuthor().isBot() && event.getMessage().getChannel().getId().equals(PluginConfig.get("channelID"))) Bukkit.getServer().broadcastMessage("[DISCORD: " + sender + ", Edited] " + MessageUtil.replaceIDwithUsername(message));
    }
}
