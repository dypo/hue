package com.dypo.hue.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * First attempt at command tab complete.
 * @author dypo
 */
public class HueTabComplete implements TabCompleter {

    /**
     * Called on every tab complete.
     * @param sender Who sent the cmd
     * @param command The cmd
     * @param alias Alias for cmd
     * @param args Command arguments
     * @return List of strings to tab complete to.
     */
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length <= 1) {
                List<String> list = new ArrayList<>();

                list.add("darkblue"); // &1
                list.add("darkgreen"); // &2
                list.add("darkaqua"); // &3
                list.add("darkred"); // &4
                list.add("darkpurple"); // &5
                list.add("gold"); // &6
                list.add("gray"); // &7
                list.add("darkgray"); // &8
                list.add("blue"); // &9
                list.add("black"); // &0
                list.add("green");
                list.add("aqua");
                list.add("red");
                list.add("lightpurple");
                list.add("yellow");
                list.add("white");
                list.add("OFF");

                return list;
            }
        }

        return null;
    }
}
