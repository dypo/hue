package com.dypo.hue.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

/**
 * Class that provides useful code shortcuts.
 * @author dypo
 */
public class Utils {

	/**
	 * Holds the plugin prefix to be used in plugin-sent messages.
	 */
	public static final String PREFIX = "&7[&bH&3u&9e&7] ";

	/**
	 * Converts chat with color code to colored chat.
	 * @param str String with code and text.
	 * @return The colored text.
	 */
	public static String chat(String str) {
		return ChatColor.translateAlternateColorCodes('&', str);
	}

	/**
	 * Sends a message to the desired player's action bar.
	 * @param player The player to receive the action bar.
	 * @param msg The string to be displayed on the action bar.
	 */
	public static void sendActionBar(Player player, String msg) {
		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(msg));
	}
}
