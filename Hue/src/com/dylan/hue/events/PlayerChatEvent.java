package com.dylan.hue.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.dylan.hue.HuePlugin;
import com.dylan.hue.utils.Utils;

public class PlayerChatEvent implements Listener {
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		String message = event.getMessage();
		String code = HuePlugin.codes.getPlayerCode(event.getPlayer());
		if (code != null)
			event.setMessage(Utils.chat(code + message));
	}
}
