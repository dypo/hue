package com.dylan.hue;

// import java.util.HashMap;

import org.bukkit.entity.Player;

public class PlayerCodes {
	// private HashMap<String, String> playerCode;
	
	public PlayerCodes() {
		
	}
	
	public String getPlayerCode(Player player) {
		// return playerCode.get(player.getName());
		
		String code = HuePlugin.getPlugin(HuePlugin.class).getConfig().getString(player.getName());
		
		return code;
	}
	
	public void setPlayerCode(Player player, String code) {
		// playerCode.put(player.getName(), code);
		
		HuePlugin.getPlugin(HuePlugin.class).getConfig().set(player.getName(), code);
	}
}
