package me.dako.essentials.cmd;

import me.dako.essentials.DakoCommand;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Hat implements DakoCommand {

	@Override
	public void executeCommand(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			return;
		}
		
		Player player = (Player) sender;
		
		if(args.length >= 1){
			if(args[0].equalsIgnoreCase("off")){
				player.getInventory().addItem(player.getInventory().getHelmet());
				player.getInventory().setHelmet(new ItemStack(Material.AIR));
				player.sendMessage(ChatColor.GREEN + "Der Helm wurde entfernt und in dein Inventar gelegt!");
				return;
			}else{
				player.sendMessage(ChatColor.RED + "Nutze /hat off, um den helm abzusetzen!");
				return;
			}
		}else{
			final ItemStack oldHelmet = player.getInventory().getHelmet();
			final ItemStack oldInHand = player.getItemInHand();
			if(player.getItemInHand() != null){
				player.getInventory().setHelmet(oldInHand);
			}else{
				return;
			}
			
			player.getInventory().remove(player.getItemInHand());
			
			if(oldHelmet != null){
				player.getInventory().addItem(oldHelmet);
			}
			
			player.sendMessage(ChatColor.GREEN + "Helm wurde gewechselt!");
			return;
		}
	}

}
