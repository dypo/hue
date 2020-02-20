package com.dypo.hue.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * First attempt at command tab complete.
 * @author Dypo
 */
public class HueTabComplete implements TabCompleter {

    /**
     * Called on every tab complete.
     * @param sender  Who sent the cmd
     * @param command The cmd
     * @param alias   Alias for cmd
     * @param args    Command arguments
     * @return List of strings to send to the tab completer.
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
                list.add("green"); // &a
                list.add("aqua"); // &b
                list.add("red"); // &c
                list.add("lightpurple"); // &d
                list.add("yellow"); // &e
                list.add("white"); // &f
                list.add("OFF");
                list.add("version");
                list.add("help");
                Collections.sort(list);
                /*
                 If a player starts typing the first argument and it doesn't match a color,
                 that color will be removed from the list.
                 */
                list.removeIf(s -> !s.toLowerCase().startsWith(args[0].toLowerCase()));

                return list;
            }
        }
        return null;
    }
}
