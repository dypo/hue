package com.dypo.hue.commands;

import com.dypo.hue.utils.UpdateChecker;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.dypo.hue.ColorGUI;
import com.dypo.hue.HuePlugin;
import com.dypo.hue.utils.Utils;

/**
 * Class that handles the main /hue command.
 * @author Dypo
 */
public class HueCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {		
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only a player can run this command.");
			
			return true;
		}
		
		Player player = (Player) sender;
		
		if (player.hasPermission("hue.use")) {
			
		
			if (args.length == 0) {
				ColorGUI gui = new ColorGUI(player);
				gui.initializeItems();
				gui.openInventory(player);
				return true;
			}
			
			String colorText = args[0].toLowerCase();
	
			switch (colorText) {
			
			case "&1":
			case "darkblue":
				if (!player.hasPermission("hue.use.darkblue")) {
					player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(player, "&1", "dark blue");
				// player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &1dark blue!"));
				break;
				
			case "&c":
			case "red":
				if (!player.hasPermission("hue.use.red")) {
					player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(player, "&c", "red");
				break;
				
			case "&4":
			case "darkred":
				if (!player.hasPermission("hue.use.darkred")) {
					player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(player, "&4", "dark red");
				break;
				
			case "&6":
			case "gold":
				if (!player.hasPermission("hue.use.gold")) {
					player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(player, "&6", "gold");
				break;
				
			case "&e":
			case "yellow":
				if (!player.hasPermission("hue.use.yellow")) {
					player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(player, "&e", "yellow");
				break;
				
			case "&2":
			case "darkgreen":
				if (!player.hasPermission("hue.use.darkgreen")) {
					player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(player, "&2", "dark green");
				break;
				
			case "&a":
			case "green":
				if (!player.hasPermission("hue.use.green")) {
					player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(player, "&a", "green");
				break;
			case "&b":
			case "aqua":
				if (!player.hasPermission("hue.use.aqua")) {
					player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(player, "&b", "aqua");
				break;
				
			case "&3":
			case "darkaqua":
				if (!player.hasPermission("hue.use.darkaqua")) {
					player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(player, "&3", "dark aqua");
				break;
				
			case "&9":
			case "blue":
				if (!player.hasPermission("hue.use.blue")) {
					player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(player, "&9", "blue");
				break;
				
			case "&d":
			case "lightpurple":
				if (!player.hasPermission("hue.use.lightpurple")) {
					player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(player, "&d", "light purple");
				break;
				
			case "&5":
			case "darkpurple":
				if (!player.hasPermission("hue.use.darkpurple")) {
					player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(player, "&5", "dark purple");
				break;
				
			case "&f":
			case "white":
				if (!player.hasPermission("hue.use.white")) {
					player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(player, "&f", "white");
				player.sendMessage(Utils.chat("&f----------------------- " + Utils.PREFIX + "&f-----------------------"));
				player.sendMessage(Utils.chat("&bIf you are trying to disable your color, please use &9/hue off"));
				player.sendMessage(Utils.chat("----------------------------------------------------"));

				break;
				
			case "&0":
			case "black":
				if (!player.hasPermission("hue.use.black")) {
					player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(player, "&0", "black");
				break;
				
			case "&8":
			case "darkgray":
				if (!player.hasPermission("hue.use.darkgray")) {
					player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(player, "&8", "dark gray");
				break;
				
			case "&7":
			case "gray":
				if (!player.hasPermission("hue.use.gray")) {
					player.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(player, "&7", "gray");
				break;
				
			case "version":
				player.sendMessage(Utils.chat(Utils.PREFIX + "&bH&3u&9e &3" + HuePlugin.getPlugin(HuePlugin.class).getDescription().getVersion() + " &b- by &9Dypo"));
				if (player.hasPermission("hue.update"))
					Utils.checkForNewVersion(player, false);
				player.sendMessage(Utils.chat("&9https://www.spigotmc.org/resources/hue-color-chat.75281/"));
				break;
			case "off":
				HuePlugin.codes.setPlayerCode(player, "", "&cOFF");
				break;
				
			case "help":
				player.sendMessage(Utils.chat(Utils.PREFIX) + "Usage: /hue <&9, darkred, off, etc.>");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fSets your persistent chat color."));
				player.sendMessage(Utils.chat("&cAvailable colors: &6&&e<colorcode>"));
				player.sendMessage(Utils.chat("&11 &22 &33 &44 &55 &66 &77 &88 &99"));
				player.sendMessage(Utils.chat("&00 &aa &bb &cc &dd &ee &ff"));
				break;
					
			default:
				player.sendMessage(Utils.chat(Utils.PREFIX + "&f" + args[0] + " &cis not a valid color. :("));
			}
		}
		else {
			player.sendMessage(Utils.chat("&cYou do not have permission for this."));
		}
		return true;
	}
}
