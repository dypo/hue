package com.dylan.hue.utils;

import org.bukkit.ChatColor;

public class Utils {
	
	public static final String PREFIX = "&7[&bH&3u&9e&7] ";
	
	public static String chat(String str) {
		return ChatColor.translateAlternateColorCodes('&', str);
	}
}
