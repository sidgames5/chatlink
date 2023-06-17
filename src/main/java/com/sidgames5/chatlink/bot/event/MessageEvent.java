package com.sidgames5.chatlink.bot.event;

import com.sidgames5.chatlink.Secrets;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static com.sidgames5.chatlink.ChatLink.LOGGER;

public class MessageEvent extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String sender = event.getMessage().getAuthor().getName();
        String message = event.getMessage().getContentRaw();
        LOGGER.info("<" + sender + "> " + message);
    }
}
