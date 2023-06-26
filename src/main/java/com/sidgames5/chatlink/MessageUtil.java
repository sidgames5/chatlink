package com.sidgames5.chatlink;

import com.sidgames5.chatlink.bot.Bot;
import net.dv8tion.jda.api.entities.Member;

import java.util.List;

public class MessageUtil {
    public static String replaceIDwithUsername(String text) {
        String[] tokens = text.split(" ");
        String result = "";

        for (String token : tokens) {
            if (token.startsWith("<@") && token.endsWith(">")) {
                String uid = token.substring(2).split(">")[0];
                result = result.concat("@" + Bot.bot.getUserById(uid).getName());
            } else {
                result = result.concat(token + " ");
            }
        }

        return result;
    }

    public static String replaceUsernameWithID(String text) {
        String[] tokens = text.split(" ");
        String result = "";

        for (String token : tokens) {
            if (token.startsWith("@")) {
                String username = token.substring(1);
                String id = "";
                List<Member> members = Bot.bot.getGuildChannelById(PluginConfig.get("channelID")).getGuild().getMembers();
                for (Member member : members) {
                    if (member.getUser().getName().toLowerCase().equals(username)) {
                        id = member.getId();
                    }
                }
                if (id.equals("")) {
                    result = result.concat("@" + username);
                } else {
                    result = result.concat("<@" + id + ">");
                }
            } else {
                result = result.concat(token + " ");
            }
        }

        return result;
    }
}
