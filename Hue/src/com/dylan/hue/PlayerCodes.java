package com.dylan.hue;

import org.bukkit.Sound;

// import java.util.HashMap;

import org.bukkit.entity.Player;

import com.dylan.hue.utils.Utils;

import java.sql.Connection;

/**
 * Class that handles online player's color codes.
 * @author dylan
 */
public class PlayerCodes {
	private boolean usingDatabase;
	private Connection connection;
	private String host, database, username, password;
	private int port;

	/**
	 * Creates an object to prepare to store codes. Uses .yml file.
	 */
	public PlayerCodes() {
		usingDatabase = false;
		host = "localhost";
		port = 3306;
		database = "mc_hue";
		username = "";
		password = "";
	}

	/**
	 * Creates an object to prepare to store codes.
	 * <p>If usingDatabase is true, then this class
	 * will store codes in a database.</p>
	 * @param usingDatabase Whether or not to store using database.
	 */
	public PlayerCodes(boolean usingDatabase) {
		this.usingDatabase = usingDatabase;
		host = "localhost";
		port = 3306;
		database = "mc_hue";
		username = "";
		password = "";
	}

	public void toggleMode() {
		if (usingDatabase)
			usingDatabase = false;
		else
			usingDatabase = true;
	}

	/**
	 * Returns what storage mode plugin is in.
	 * @return
	 */
	public String checkMode() {
		return (usingDatabase ? "Database" : "YML File");
	}

	/**
	 * Get the specified player's color code.
	 * @param player The player to get the color code from.
	 * @return The code of the player.
	 */
	public String getPlayerCode(Player player) {
		
		String code = HuePlugin.getPlugin(HuePlugin.class).getConfig().getString(player.getName());
		
		return code;
	}

	/**
	 * Sets the specified player's color code.
	 * @param player The player whose color code to set.
	 * @param code The code you want to set a player to.
	 * @param color The name of the color, mainly for action bar msg.
	 */
	public void setPlayerCode(Player player, String code, String color) {
		if (color.equalsIgnoreCase("off")) {
			HuePlugin.getPlugin(HuePlugin.class).getConfig().addDefault(player.getName(), null);
			HuePlugin.getPlugin(HuePlugin.class).getConfig().set(player.getName(), null);
		}
		else {
			HuePlugin.getPlugin(HuePlugin.class).getConfig().addDefault(player.getName(), code);
			HuePlugin.getPlugin(HuePlugin.class).getConfig().set(player.getName(), code);
		}
		HuePlugin.getPlugin(HuePlugin.class).saveConfig();
		Utils.sendActionBar(player, Utils.chat("&bH&3u&9e &f- Chat color has been changed to " + code + color + "!"));
		player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 9, 4);
	}
}
