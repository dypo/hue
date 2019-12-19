package com.dylan.hue;

import org.bukkit.Sound;

// import java.util.HashMap;

import org.bukkit.entity.Player;

import com.dylan.hue.utils.Utils;

public class PlayerCodes {
	
	public PlayerCodes() {
		
	}
	
	public String getPlayerCode(Player player) {
		
		String code = HuePlugin.getPlugin(HuePlugin.class).getConfig().getString(player.getName());
		
		return code;
	}
	
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
