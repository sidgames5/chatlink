package com.sidgames5.chatlink.bot.event;

import com.sidgames5.chatlink.MessageUtil;
import com.sidgames5.chatlink.PluginConfig;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.MessageUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageEvents extends ListenerAdapter {
    private static final Logger logger = LoggerFactory.getLogger("ChatLink Bot");
    public void onMessageReceived(MessageReceivedEvent event) {
        String sender = event.getMessage().getAuthor().getName();
        String message = event.getMessage().getContentRaw();
        //logger.info("[DISCORD: " + sender + "] " + message);
        if (!event.getMessage().getAuthor().isBot() && event.isFromGuild() && event.getMessage().getChannel().getId().equals(PluginConfig.get("channelID"))) Bukkit.getServer().broadcastMessage("[DISCORD: " + sender + "] " + MessageUtil.replaceIDwithUsername(message));
    }
    public void onMessageUpdate(MessageUpdateEvent event) {
        String sender = event.getMessage().getAuthor().getName();
        String message = event.getMessage().getContentRaw();
        //logger.info("[DISCORD: " + sender + ", Edited] " + message);
        if (!event.getMessage().getAuthor().isBot() && event.isFromGuild() && event.getMessage().getChannel().getId().equals(PluginConfig.get("channelID"))) Bukkit.getServer().broadcastMessage("[DISCORD: " + sender + ", Edited] " + MessageUtil.replaceIDwithUsername(message));
    }
}
