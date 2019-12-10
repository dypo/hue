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
		
		if (args[0] == "") {
			sender.sendMessage(Utils.chat(Utils.PREFIX + "&fUsage: /cc <red|gold|darkred|etc.>"));
			sender.sendMessage(Utils.chat(Utils.PREFIX + "&fSets your persistant chat color."));
			return true;
		}
		
		Player player = (Player) sender;
		String colorText = args[0].toLowerCase();
		
		if (player.hasPermission("hue.use")) {
			switch (colorText) {
			case "red":
				HuePlugin.codes.setPlayerCode(player, "&c");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &cred!"));
				break;
			case "darkred":
				HuePlugin.codes.setPlayerCode(player, "&4");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &4dark red!"));
				break;
			case "gold":
				HuePlugin.codes.setPlayerCode(player, "&6");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &6gold!"));
				break;
			case "yellow":
				HuePlugin.codes.setPlayerCode(player, "&e");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &eyellow!"));
				break;
			case "darkgreen":
				HuePlugin.codes.setPlayerCode(player, "&2");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &2dark green!"));
				break;
			case "green":
				HuePlugin.codes.setPlayerCode(player, "&a");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &agreen!"));
				break;
			case "aqua":
				HuePlugin.codes.setPlayerCode(player, "&b");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &baqua!"));
				break;
			case "darkaqua":
				HuePlugin.codes.setPlayerCode(player, "&3");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &3dark aqua!"));
				break;
			case "blue":
				HuePlugin.codes.setPlayerCode(player, "&9");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &9blue!"));
				break;
			case "lightpurple":
				HuePlugin.codes.setPlayerCode(player, "&d");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &dlight purple!"));
				break;
			case "darkpurple":
				HuePlugin.codes.setPlayerCode(player, "&5");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &5dark purple!"));
				break;
			case "white":
				HuePlugin.codes.setPlayerCode(player, "&f");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &fwhite!"));
				break;
			case "black":
				HuePlugin.codes.setPlayerCode(player, "&0");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &0black!"));
				break;
			case "darkgray":
				HuePlugin.codes.setPlayerCode(player, "&8");
				player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &8dark gray!"));
				break;
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
