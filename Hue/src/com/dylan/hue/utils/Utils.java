package com.dylan.hue.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Utils {
	
	public static final String PREFIX = "&7[&bH&3u&9e&7] ";
	
	public static String chat(String str) {
		return ChatColor.translateAlternateColorCodes('&', str);
	}
	
	public static void sendActionBar(Player player, String msg) {
		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(msg));
	}
}
