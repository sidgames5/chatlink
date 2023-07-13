package com.sidgames5.chatlink;

import net.fabricmc.loader.api.FabricLoader;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ConfigManager {
    public static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(), "chatlink.config.json");

    public static void load() throws IOException {
        String content = Files.readString(CONFIG_FILE.toPath());

        var json = new JSONObject(content);
        Config.botToken = json.getString("botToken");
        Config.channelID = json.getString("channelID");
        Config.webhookURL = json.getString("webhookURL");
    }

    public static void init() throws IOException {
        if (!CONFIG_FILE.exists()) {
            var json = new JSONObject();
            json.put("botToken", Config.botToken);
            json.put("channelID", Config.channelID);
            json.put("webhookURL", Config.webhookURL);

            var content = json.toString();
            Files.writeString(CONFIG_FILE.toPath(), content);
        }
    }
}
