package com.sidgames5.chatlink.listeners;

import com.sidgames5.chatlink.bot.Bot;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.IOException;

public class PlayerEvents implements Listener {
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        try {
            Bot.sendToDiscord("Server", event.getPlayer().getName() + " just joined");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @EventHandler
    public static void onPlayerQuit(PlayerQuitEvent event) {
        try {
            Bot.sendToDiscord("Server", event.getPlayer().getName() + " just left");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
