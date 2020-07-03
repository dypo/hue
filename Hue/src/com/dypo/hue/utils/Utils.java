package com.dypo.hue.utils;

import com.dypo.hue.HuePlugin;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
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
	 * Converts chat to a given hex code's color. This assumes the hex code is valid.
	 * @param str The message
	 * @param hex Hex code
	 * @return Colored text.
	 */
	public static String chatHex(String str, String hex) {
		return ChatColor.of(hex) + str;
	}

	/**
	 * Sends a message to the desired player's action bar.
	 * @param player The player to receive the action bar.
	 * @param msg The string to be displayed on the action bar.
	 */
	public static void sendActionBar(Player player, String msg) {
		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(msg));
	}

	/**
	 * Checks for a new version and then sends the outcome to the player.
	 * @param player The player to receive the message.
	 * @param auto Depending on whether the player typed a command to see version, or if they just joined, output will differ.
	 */
	public static void checkForNewVersion(Player player, boolean auto) {
		UpdateChecker
				.of(HuePlugin.getPlugin(HuePlugin.class))
				.resourceId(75281)
				.handleResponse((versionResponse, version) -> {
					switch (versionResponse) {
						case FOUND_NEW:
							player.sendMessage(Utils.chat(Utils.PREFIX + "&bNew version was found: &3"
									+ version + " &9(using " + HuePlugin.getPlugin(HuePlugin.class).getDescription().getVersion() + "&9)"));
							if (auto) {
								player.sendMessage(Utils.chat(Utils.PREFIX + "&9Click here:"));
								player.sendMessage(Utils.chat("&3https://www.spigotmc.org/resources/hue-color-chat.75281/"));
							}
								break;
						case LATEST:
							if (!auto)
								player.sendMessage(Utils.chat(Utils.PREFIX + "&bYou are on the latest version of the plugin."));
							break;
						case UNAVAILABLE:
							player.sendMessage(Utils.chat(Utils.PREFIX + "&cUnable to perform an update check. Check manually:"));
							if (!auto)
								player.sendMessage(Utils.chat("&chttps://www.spigotmc.org/resources/hue-color-chat.75281/"));
					}
				}).check();
	}
}
