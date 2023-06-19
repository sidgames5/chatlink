package com.sidgames5.chatlink.listeners;

import com.sidgames5.chatlink.bot.Bot;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        Bot.sendToDiscord(event.getPlayer().getName(), event.getMessage());
    }
}
