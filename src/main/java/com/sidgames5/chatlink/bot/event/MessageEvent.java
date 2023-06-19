package com.sidgames5.chatlink.bot.event;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;

public class MessageEvent extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String sender = event.getMessage().getAuthor().getName();
        String message = event.getMessage().getContentRaw();
        //logger.info("[DISCORD: " + sender + "] " + message);
        Bukkit.getServer().broadcastMessage("[DISCORD: " + sender + "] " + message);
    }
}