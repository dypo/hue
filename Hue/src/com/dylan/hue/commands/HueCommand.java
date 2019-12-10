package com.dylan.hue.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.dylan.hue.HuePlugin;
import com.dylan.hue.utils.Utils;

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
				sender.sendMessage(Utils.chat(Utils.PREFIX) + "Usage: /cc <&c, &9, darkred, etc.>");
				sender.sendMessage(Utils.chat(Utils.PREFIX + "&fSets your persistant chat color."));
				sender.sendMessage(Utils.chat("&cAvailable colors:"));
				sender.sendMessage(Utils.chat("&11 &22 &33 &44 &55 &66 &77 &88 &99"));
				sender.sendMessage(Utils.chat("&aa &bb &cc &dd &ee &ff"));
				return true;
			}
			
			String colorText = args[0].toLowerCase();
	
			switch (colorText) {
			case "&c":
			case "red":
				HuePlugin.codes.setPlayerCode(player, "&c");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &cred!"));
				break;
			case "&4":
			case "darkred":
				HuePlugin.codes.setPlayerCode(player, "&4");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &4dark red!"));
				break;
			case "&6":
			case "gold":
				HuePlugin.codes.setPlayerCode(player, "&6");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &6gold!"));
				break;
			case "&e":
			case "yellow":
				HuePlugin.codes.setPlayerCode(player, "&e");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &eyellow!"));
				break;
			case "&2":
			case "darkgreen":
				HuePlugin.codes.setPlayerCode(player, "&2");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &2dark green!"));
				break;
			case "&a":
			case "green":
				HuePlugin.codes.setPlayerCode(player, "&a");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &agreen!"));
				break;
			case "&b":
			case "aqua":
				HuePlugin.codes.setPlayerCode(player, "&b");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &baqua!"));
				break;
			case "&3":
			case "darkaqua":
				HuePlugin.codes.setPlayerCode(player, "&3");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &3dark aqua!"));
				break;
			case "&9":
			case "blue":
				HuePlugin.codes.setPlayerCode(player, "&9");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &9blue!"));
				break;
			case "&d":
			case "lightpurple":
				HuePlugin.codes.setPlayerCode(player, "&d");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &dlight purple!"));
				break;
			case "&5":
			case "darkpurple":
				HuePlugin.codes.setPlayerCode(player, "&5");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &5dark purple!"));
				break;
			case "&f":
			case "white":
				HuePlugin.codes.setPlayerCode(player, "&f");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &fwhite!"));
				break;
			case "&0":
			case "black":
				HuePlugin.codes.setPlayerCode(player, "&0");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &0black!"));
				break;
			case "&8":
			case "darkgray":
				HuePlugin.codes.setPlayerCode(player, "&8");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &8dark gray!"));
				break;
			case "&7":
			case "gray":
				HuePlugin.codes.setPlayerCode(player, "&7");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &7gray!"));
	
				break;
			default:
				player.sendMessage(Utils.chat(Utils.PREFIX + "&f" + args[0] + " &cis not a valid color."));
			}
			return true;	
		}
		else {
			player.sendMessage(Utils.chat("&cYou do not have permission for this."));
			return true;
		}
	}
}
