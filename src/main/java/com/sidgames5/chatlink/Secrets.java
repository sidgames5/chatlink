package com.sidgames5.chatlink;

public class Secrets {
    public static String get(String key) {
        return null;
    }
    public static String getFromConfig(String key) {
        switch (key) {
            case "BOT_TOKEN" -> {
                return "";
            }
            case "CHANNEL_ID" -> {
                return "1119701666929844295";
            }
        }
        return null;
    }
}
