package com.dylan.hue;

import org.bukkit.plugin.java.JavaPlugin;

import com.dylan.hue.commands.HueCommand;
import com.dylan.hue.events.PlayerChatEvent;

public class HuePlugin extends JavaPlugin {
	
	public static PlayerCodes codes = new PlayerCodes();

	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		getServer().getPluginManager().registerEvents(new PlayerChatEvent(), this);
		this.getCommand("cc").setExecutor(new HueCommand());
	}
	
	@Override
	public void onDisable() {
		saveConfig();
	}
}
