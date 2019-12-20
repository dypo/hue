package com.dylan.hue;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.dylan.hue.utils.Utils;


public class ColorGUI implements InventoryHolder, Listener {

	private final Inventory inv;

	public ColorGUI() {
		inv = Bukkit.createInventory(this, 18, Utils.chat("&bH&3u&9e &rColors"));
	}

	@Override
	public Inventory getInventory() {
		return inv;
	}

	public void initializeItems() {
		inv.addItem(createGuiItem(Material.BLUE_CONCRETE, Utils.chat("&1&lDark Blue"), Utils.chat("&fSet your color to &1dark blue")));
		inv.addItem(createGuiItem(Material.GREEN_CONCRETE, Utils.chat("&2&lDark Green"), Utils.chat("&fSet your color to &2dark green")));
		inv.addItem(createGuiItem(Material.CYAN_CONCRETE, Utils.chat("&3&lDark Aqua"), Utils.chat("&fSet your color to &3dark aqua")));
		inv.addItem(createGuiItem(Material.RED_CONCRETE, Utils.chat("&4&lDark Red"), Utils.chat("&fSet your color to &4dark red")));
		inv.addItem(createGuiItem(Material.PURPLE_CONCRETE, Utils.chat("&5&lDark Purple"), Utils.chat("&fSet your color to &5dark purple")));
		inv.addItem(createGuiItem(Material.ORANGE_CONCRETE, Utils.chat("&6&lGold"), Utils.chat("&fSet your color to &6gold")));
		inv.addItem(createGuiItem(Material.LIGHT_GRAY_CONCRETE, Utils.chat("&7&lGray"), Utils.chat("&fSet your color to &7gray")));
		inv.addItem(createGuiItem(Material.GRAY_CONCRETE, Utils.chat("&8&lDark Gray"), Utils.chat("&fSet your color to &8dark gray")));
		inv.addItem(createGuiItem(Material.LIGHT_BLUE_CONCRETE, Utils.chat("&9&lBlue"), Utils.chat("&fSet your color to &9blue")));
		
		inv.addItem(createGuiItem(Material.BLACK_CONCRETE, Utils.chat("&lBlack"), Utils.chat("&fSet your color to &fblack")));
		inv.addItem(createGuiItem(Material.LIME_CONCRETE, Utils.chat("&a&lGreen"), Utils.chat("&fSet your color to &agreen")));
		inv.addItem(createGuiItem(Material.LIGHT_BLUE_CONCRETE_POWDER, Utils.chat("&b&lAqua"), Utils.chat("&fSet your color to &baqua")));
		inv.addItem(createGuiItem(Material.PINK_CONCRETE, Utils.chat("&c&lRed"), Utils.chat("&fSet your color to &cred")));
		inv.addItem(createGuiItem(Material.MAGENTA_CONCRETE, Utils.chat("&d&lLight Purple"), Utils.chat("&fSet your color to &dlight purple")));
		inv.addItem(createGuiItem(Material.YELLOW_CONCRETE, Utils.chat("&e&lYellow"), Utils.chat("&fSet your color to &eyellow")));
		inv.addItem(createGuiItem(Material.WHITE_CONCRETE, Utils.chat("&f&lWhite"), Utils.chat("&fSet your color to &fwhite")));
		inv.addItem(createGuiItem(Material.GLASS, Utils.chat("&fOFF"), Utils.chat("&cDisable your chat color")));
	}

	private ItemStack createGuiItem(Material material, String name, String...lore) {
		ItemStack item = new ItemStack(material, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		ArrayList<String> metalore = new ArrayList<String>();    

		for(String lorecomments : lore) {

			metalore.add(lorecomments);

		}

		meta.setLore(metalore);
		item.setItemMeta(meta);
		return item;
	}

	// You can open the inventory with this
	public void openInventory(Player p) {
		p.openInventory(inv);
	}

}


