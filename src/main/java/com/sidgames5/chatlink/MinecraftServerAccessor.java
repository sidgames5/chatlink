package com.sidgames5.chatlink;

import com.sidgames5.chatlink.bot.MinecraftMessageSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;

public class MinecraftServerAccessor implements MinecraftMessageSender {
    private static MinecraftServer server;
    private static boolean isServerSet;
    public static void setServer(MinecraftServer server) {
        MinecraftServerAccessor.server = server;
        MinecraftServerAccessor.isServerSet = true;
    }
    public static MinecraftServer getServer() {
        return MinecraftServerAccessor.isServerSet ? MinecraftServerAccessor.server : null;
    }

    @Override
    public void sendMessage(String s) {
        server.sendMessage(Text.literal(s));
    }
}
