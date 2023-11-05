package com.sermister1.tpwandplugin;

import java.util.Arrays;
import java.util.List;

//import java.awt.TextComponent;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.kyori.adventure.text.Component;

public class CommandGiveStick  implements CommandExecutor{
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			ItemStack stack = new ItemStack(Material.STICK);
			stack.setAmount(1);
			Component comp = Component.text("Teleport");
			List<Component> comp1 = Arrays.asList(comp);
			stack.lore(comp1);
			player.getInventory().addItem(stack);
			return true;
		}
	return false;
	}
}
