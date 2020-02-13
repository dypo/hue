package com.dylan.hue.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;

import com.dylan.hue.HuePlugin;
import com.dylan.hue.utils.Utils;

public class Events implements Listener {

	/**
	 * Event for when a player chats.
	 * @param event
	 */
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		String message = event.getMessage();
		String code = HuePlugin.codes.getPlayerCode(event.getPlayer());
		if (code != null)
			event.setMessage(Utils.chat(code + message));
	}

	/**
	 * Event for when a player clicks on a GUI item.
	 * @param event
	 */
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		String code = HuePlugin.codes.getPlayerCode((Player) event.getWhoClicked());
		String color = "";
		if (code != null) {
			switch (code) {
				case "&1":
					color = "Dark Blue";
					break;
				case "&2":
					color = "Dark Green";
					break;
				case "&3":
					color = "Dark Aqua";
					break;
				case "&4":
					color = "Dark Red";
					break;
				case "&5":
					color = "Dark Purple";
					break;
				case "&6":
					color = "Gold";
					break;
				case "&7":
					color = "Gray";
					break;
				case "&8":
					color = "Dark Gray";
					break;
				case "&9":
					color = "Blue";
					break;
				case "&0":
					color = "Black";
					break;
				case "&a":
					color = "Green";
					break;
				case "&b":
					color = "Aqua";
					break;
				case "&c":
					color = "Red";
					break;
				case "&d":
					color = "Light Purple";
					break;
				case "&f":
					color = "White";
					break;
				case "&e":
					color = "Yellow";
					break;
				default:
					color = "OFF";
					code = "&c&l";
			}
		} else {
			color = "OFF";
			code = "&c&l";
		}
		if (!event.getView().getTitle().equals(Utils.chat("&bH&3u&9e &rColors - Have: " + code + color))) {
			return;
		}
		if (event.getClick().equals(ClickType.NUMBER_KEY)){
			event.setCancelled(true);
		}
		event.setCancelled(true);

		Player player = (Player) event.getWhoClicked();
		ItemStack clickedItem = event.getCurrentItem();

		// verify current item is not null
		if (clickedItem == null || clickedItem.getType() == Material.AIR)
			return;

		// Using slots click is a best option for your inventory click's
		if (event.getRawSlot() == 0) {
			if (!player.hasPermission("hue.use.darkblue")) {
				player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
				player.closeInventory();

				return;
			}
			player.closeInventory();

			HuePlugin.codes.setPlayerCode(player, "&1", "dark blue");
		}
		
		if (event.getRawSlot() == 1) {
			if (!player.hasPermission("hue.use.darkgreen")) {
				player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
				player.closeInventory();

				return;
			}
			player.closeInventory();

			HuePlugin.codes.setPlayerCode(player, "&2", "dark green");
		}
		
		if (event.getRawSlot() == 2) {
			if (!player.hasPermission("hue.use.darkaqua")) {
				player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
				player.closeInventory();

				return;
			}
			player.closeInventory();

			HuePlugin.codes.setPlayerCode(player, "&3", "dark aqua");
		}
		
		if (event.getRawSlot() == 3) {
			if (!player.hasPermission("hue.use.darkred")) {
				player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
				player.closeInventory();

				return;
			}
			player.closeInventory();

			HuePlugin.codes.setPlayerCode(player, "&4", "dark red");
		}
		
		if (event.getRawSlot() == 4) {
			if (!player.hasPermission("hue.use.darkpurple")) {
				player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
				player.closeInventory();

				return;
			}
			player.closeInventory();

			HuePlugin.codes.setPlayerCode(player, "&5", "dark purple");
		}
		
		if (event.getRawSlot() == 5) {
			if (!player.hasPermission("hue.use.gold")) {
				player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
				player.closeInventory();

				return;
			}
			player.closeInventory();

			HuePlugin.codes.setPlayerCode(player, "&6", "gold");
		}
		
		if (event.getRawSlot() == 6) {
			if (!player.hasPermission("hue.use.gray")) {
				player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
				player.closeInventory();

				return;
			}
			player.closeInventory();

			HuePlugin.codes.setPlayerCode(player, "&7", "gray");
		}
		
		if (event.getRawSlot() == 7) {
			if (!player.hasPermission("hue.use.darkgray")) {
				player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
				player.closeInventory();

				return;
			}
			player.closeInventory();

			HuePlugin.codes.setPlayerCode(player, "&8", "dark gray");
		}
		
		if (event.getRawSlot() == 8) {
			if (!player.hasPermission("hue.use.blue")) {
				player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
				player.closeInventory();

				return;
			}
			player.closeInventory();

			HuePlugin.codes.setPlayerCode(player, "&9", "blue");
		}
		
		if (event.getRawSlot() == 9) {
			if (!player.hasPermission("hue.use.black")) {
				player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
				player.closeInventory();

				return;
			}
			player.closeInventory();

			HuePlugin.codes.setPlayerCode(player, "&0", "black");
		}
		
		if (event.getRawSlot() == 10) {
			if (!player.hasPermission("hue.use.green")) {
				player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
				player.closeInventory();

				return;
			}
			player.closeInventory();

			HuePlugin.codes.setPlayerCode(player, "&a", "green");
		}
		
		if (event.getRawSlot() == 11) {
			if (!player.hasPermission("hue.use.aqua")) {
				player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
				player.closeInventory();

				return;
			}
			player.closeInventory();

			HuePlugin.codes.setPlayerCode(player, "&b", "aqua");
		}
		
		if (event.getRawSlot() == 12) {
			if (!player.hasPermission("hue.use.red")) {
				player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
				player.closeInventory();

				return;
			}
			player.closeInventory();

			HuePlugin.codes.setPlayerCode(player, "&c", "red");
		}
		
		if (event.getRawSlot() == 13) {
			if (!player.hasPermission("hue.use.lightpurple")) {
				player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
				player.closeInventory();

				return;
			}
			player.closeInventory();

			HuePlugin.codes.setPlayerCode(player, "&d", "light purple");
		}
		
		if (event.getRawSlot() == 14) {
			if (!player.hasPermission("hue.use.yellow")) {
				player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
				player.closeInventory();

				return;
			}
			player.closeInventory();

			HuePlugin.codes.setPlayerCode(player, "&e", "yellow");
		}
		
		if (event.getRawSlot() == 15) {
			if (!player.hasPermission("hue.use.white")) {
				player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
				player.closeInventory();

				return;
			}
			player.closeInventory();
			player.sendMessage(Utils.chat("&f----------------------- " + Utils.PREFIX + "&f-----------------------"));
			player.sendMessage(Utils.chat("&bIf you are trying to disable your color, please use &9/hue off"));
			player.sendMessage(Utils.chat("----------------------------------------------------"));
			HuePlugin.codes.setPlayerCode(player, "&f", "white");
		}
		
		if (event.getRawSlot() == 16) {
			player.closeInventory();

			HuePlugin.codes.setPlayerCode(player, "", "&cOFF");

			return;
		}
		
	}
}

