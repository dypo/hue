package com.dylan.hue;

import org.bukkit.plugin.java.JavaPlugin;

import com.dylan.hue.commands.HueCommand;
import com.dylan.hue.events.Events;

public class HuePlugin extends JavaPlugin {
	
	public static PlayerCodes codes = new PlayerCodes();

	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		getServer().getPluginManager().registerEvents(new Events(), this);
		getServer().getPluginManager().registerEvents(new ColorGUI(), this);
		
		this.getCommand("hue").setExecutor(new HueCommand());
	}
	
	@Override
	public void onDisable() {
		saveConfig();
	}
}
