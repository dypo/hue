package com.dypo.hue;

import org.bukkit.Sound;

// import java.util.HashMap;

import org.bukkit.entity.Player;

import com.dypo.hue.utils.Utils;


/**
 * Class that handles online player's color codes.
 * @author dypo
 */
public class PlayerCodes {

	/**
	 * Creates an object to prepare to store codes. Uses .yml file.
	 */
	public PlayerCodes() {
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
