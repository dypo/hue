package com.dylan.hue;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class PlayerCodes {
	private HashMap<String, String> playerCode;
	
	public PlayerCodes() {
		playerCode = new HashMap<String, String>();
	}
	
	public String getPlayerCode(Player player) {
		return playerCode.get(player.getName());
	}
	
	public void setPlayerCode(Player player, String code) {
		playerCode.put(player.getName(), code);
	}
	
}
