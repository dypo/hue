package com.dypo.hue;

import com.dypo.hue.commands.HueCommand;
import com.dypo.hue.events.Events;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Handles plugin startup.
 * @author dypo
 */
public class HuePlugin extends JavaPlugin {

	/**
	 * Stores every online player's color code.
	 */
	public static PlayerCodes codes = new PlayerCodes();

	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		getServer().getPluginManager().registerEvents(new Events(), this);
		
		this.getCommand("hue").setExecutor(new HueCommand());
	}
	
	@Override
	public void onDisable() {
		saveConfig();
	}
}
