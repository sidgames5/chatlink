package com.sidgames5.chatlink.bot.event;

import com.sidgames5.chatlink.PluginConfig;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;

public class MessageEvents extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String sender = event.getMessage().getAuthor().getName();
        String message = event.getMessage().getContentRaw();
        //logger.info("[DISCORD: " + sender + "] " + message);
        if (!event.getMessage().getAuthor().isBot() && event.getMessage().getChannel().getId().equals(PluginConfig.get("channelID"))) Bukkit.getServer().broadcastMessage("[DISCORD: " + sender + "] " + message);
    }
    public void onGuildMessageUpdates(GuildMessageUpdateEvent event) {
        String sender = event.getMessage().getAuthor().getName();
        String message = event.getMessage().getContentRaw();
        //logger.info("[DISCORD: " + sender + "] (Edited) " + message);
        if (!event.getMessage().getAuthor().isBot() && event.getMessage().getChannel().getId().equals(PluginConfig.get("channelID"))) Bukkit.getServer().broadcastMessage("[DISCORD: " + sender + ", Edited] " + message);
    }
}
