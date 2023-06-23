package com.sidgames5.chatlink;

import com.sidgames5.chatlink.bot.Bot;

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
}
