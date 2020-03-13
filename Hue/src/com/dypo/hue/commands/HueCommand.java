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
			if (args.length == 1)
				setColor(player, args);
			else
				setColor(player, HuePlugin.getPlugin(HuePlugin.class).getServer().getPlayer(args[1]), args);
		}
		else {
			player.sendMessage(Utils.chat("&cYou do not have permission for this."));
		}
		return true;
	}

	public void setColor(Player caller, String[] args) {
		String colorText = args[0].toLowerCase();

		switch (colorText) {

			case "&1":
			case "darkblue":
				if (!caller.hasPermission("hue.use.darkblue")) {
					caller.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(caller, "&1", "dark blue");
				// player.sendMessage(Utils.chat(Utils.PREFIX + "&fColor set to &1dark blue!"));
				break;

			case "&c":
			case "red":
				if (!caller.hasPermission("hue.use.red")) {
					caller.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(caller, "&c", "red");
				break;

			case "&4":
			case "darkred":
				if (!caller.hasPermission("hue.use.darkred")) {
					caller.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(caller, "&4", "dark red");
				break;

			case "&6":
			case "gold":
				if (!caller.hasPermission("hue.use.gold")) {
					caller.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(caller, "&6", "gold");
				break;

			case "&e":
			case "yellow":
				if (!caller.hasPermission("hue.use.yellow")) {
					caller.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(caller, "&e", "yellow");
				break;

			case "&2":
			case "darkgreen":
				if (!caller.hasPermission("hue.use.darkgreen")) {
					caller.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(caller, "&2", "dark green");
				break;

			case "&a":
			case "green":
				if (!caller.hasPermission("hue.use.green")) {
					caller.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(caller, "&a", "green");
				break;
			case "&b":
			case "aqua":
				if (!caller.hasPermission("hue.use.aqua")) {
					caller.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(caller, "&b", "aqua");
				break;

			case "&3":
			case "darkaqua":
				if (!caller.hasPermission("hue.use.darkaqua")) {
					caller.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(caller, "&3", "dark aqua");
				break;

			case "&9":
			case "blue":
				if (!caller.hasPermission("hue.use.blue")) {
					caller.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(caller, "&9", "blue");
				break;

			case "&d":
			case "lightpurple":
				if (!caller.hasPermission("hue.use.lightpurple")) {
					caller.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(caller, "&d", "light purple");
				break;

			case "&5":
			case "darkpurple":
				if (!caller.hasPermission("hue.use.darkpurple")) {
					caller.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(caller, "&5", "dark purple");
				break;

			case "&f":
			case "white":
				if (!caller.hasPermission("hue.use.white")) {
					caller.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(caller, "&f", "white");
				caller.sendMessage(Utils.chat("&f----------------------- " + Utils.PREFIX + "&f-----------------------"));
				caller.sendMessage(Utils.chat("&bIf you are trying to disable your color, please use &9/hue off"));
				caller.sendMessage(Utils.chat("----------------------------------------------------"));

				break;

			case "&0":
			case "black":
				if (!caller.hasPermission("hue.use.black")) {
					caller.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(caller, "&0", "black");
				break;

			case "&8":
			case "darkgray":
				if (!caller.hasPermission("hue.use.darkgray")) {
					caller.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(caller, "&8", "dark gray");
				break;

			case "&7":
			case "gray":
				if (!caller.hasPermission("hue.use.gray")) {
					caller.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
					break;
				}
				HuePlugin.codes.setPlayerCode(caller, "&7", "gray");
				break;

			case "version":
				caller.sendMessage(Utils.chat(Utils.PREFIX + "&bH&3u&9e &3" + HuePlugin.getPlugin(HuePlugin.class).getDescription().getVersion() + " &b- by &9Dypo"));
				if (caller.hasPermission("hue.update"))
					Utils.checkForNewVersion(caller, false);
				caller.sendMessage(Utils.chat("&9https://www.spigotmc.org/resources/hue-color-chat.75281/"));
				break;
			case "off":
				HuePlugin.codes.setPlayerCode(caller, "", "&cOFF");
				break;

			case "help":
				caller.sendMessage(Utils.chat(Utils.PREFIX) + "Usage: /hue <&9, darkred, off, etc.>");
				caller.sendMessage(Utils.chat(Utils.PREFIX + "&fSets your persistent chat color."));
				caller.sendMessage(Utils.chat("&cAvailable colors: &6&&e<colorcode>"));
				caller.sendMessage(Utils.chat("&11 &22 &33 &44 &55 &66 &77 &88 &99"));
				caller.sendMessage(Utils.chat("&00 &aa &bb &cc &dd &ee &ff"));
				break;

			default:
				caller.sendMessage(Utils.chat(Utils.PREFIX + "&f" + args[0] + " &cis not a valid color. :("));
		}
	}

	public void setColor(Player caller, Player target, String[] args) {
		String colorText = args[0].toLowerCase();

		if (caller.hasPermission("hue.other")) {
			if (!(target == null)) {
				switch (colorText) {
					case "&1":
					case "darkblue":
						HuePlugin.codes.setPlayerCode(target, "&1", "dark blue");
						break;
					case "&c":
					case "red":
						HuePlugin.codes.setPlayerCode(target, "&c", "red");
						break;
					case "&4":
					case "darkred":
						HuePlugin.codes.setPlayerCode(target, "&4", "dark red");
						break;
					case "&6":
					case "gold":
						HuePlugin.codes.setPlayerCode(target, "&6", "gold");
						break;
					case "&e":
					case "yellow":
						HuePlugin.codes.setPlayerCode(target, "&e", "yellow");
						break;
					case "&2":
					case "darkgreen":
						HuePlugin.codes.setPlayerCode(target, "&2", "dark green");
						break;
					case "&a":
					case "green":
						HuePlugin.codes.setPlayerCode(target, "&a", "green");
						break;
					case "&b":
					case "aqua":
						HuePlugin.codes.setPlayerCode(target, "&b", "aqua");
						break;

					case "&3":
					case "darkaqua":
						HuePlugin.codes.setPlayerCode(target, "&3", "dark aqua");
						break;

					case "&9":
					case "blue":
						HuePlugin.codes.setPlayerCode(target, "&9", "blue");
						break;

					case "&d":
					case "lightpurple":
						HuePlugin.codes.setPlayerCode(target, "&d", "light purple");
						break;

					case "&5":
					case "darkpurple":
						HuePlugin.codes.setPlayerCode(target, "&5", "dark purple");
						break;

					case "&f":
					case "white":
						HuePlugin.codes.setPlayerCode(target, "&f", "white");
						caller.sendMessage(Utils.chat("&f----------------------- " + Utils.PREFIX + "&f-----------------------"));
						caller.sendMessage(Utils.chat("&bIf you are trying to disable their color, please use &9/hue off " + args[1]));
						caller.sendMessage(Utils.chat("----------------------------------------------------"));

						break;

					case "&0":
					case "black":
						HuePlugin.codes.setPlayerCode(target, "&0", "black");
						break;

					case "&8":
					case "darkgray":
						HuePlugin.codes.setPlayerCode(target, "&8", "dark gray");
						break;

					case "&7":
					case "gray":
						HuePlugin.codes.setPlayerCode(target, "&7", "gray");
						break;

					case "version":
						caller.sendMessage(Utils.chat(Utils.PREFIX + "&bH&3u&9e &3" + HuePlugin.getPlugin(HuePlugin.class).getDescription().getVersion() + " &b- by &9Dypo"));
						if (caller.hasPermission("hue.update"))
							Utils.checkForNewVersion(caller, false);
						caller.sendMessage(Utils.chat("&9https://www.spigotmc.org/resources/hue-color-chat.75281/"));
						break;
					case "off":
						HuePlugin.codes.setPlayerCode(target, "", "&cOFF");
						break;

					case "help":
						caller.sendMessage(Utils.chat(Utils.PREFIX) + "Usage: /hue <&9, darkred, off, etc.>");
						caller.sendMessage(Utils.chat(Utils.PREFIX + "&fSets your persistent chat color."));
						caller.sendMessage(Utils.chat("&cAvailable colors: &6&&e<colorcode>"));
						caller.sendMessage(Utils.chat("&11 &22 &33 &44 &55 &66 &77 &88 &99"));
						caller.sendMessage(Utils.chat("&00 &aa &bb &cc &dd &ee &ff"));
						break;

					default:
						caller.sendMessage(Utils.chat(Utils.PREFIX + "&f" + args[0] + " &cis not a valid color. :("));
				}
			}
			else
				caller.sendMessage(Utils.chat(args[1] + " &ccould not be found."));
		}
		else
			caller.sendMessage(Utils.chat("&cYou do not have permission to set another player's color."));
	}

	private boolean ass(Player caller) {
		if (!caller.hasPermission("hue.use.darkblue.other")) {
			caller.sendMessage(Utils.chat("&cYou do not have permission to use this color."));
			return true;
		}
		return false;
	}
}
