package me.dako.essentials.cmd;

import me.dako.essentials.DakoCommand;

import org.bukkit.ChatColor;
import org.bukkit.TreeType;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tree implements DakoCommand{

	@Override
	public void executeCommand(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			return;
		}
		
		Player player = (Player) sender;
		
		if(args.length >= 1){
			if(args[0].equalsIgnoreCase("tree") ||args[0].equalsIgnoreCase("birch") ||args[0].equalsIgnoreCase("redwood") ||args[0].equalsIgnoreCase("redmushroom") ||args[0].equalsIgnoreCase("brownmushroom") ||args[0].equalsIgnoreCase("jungle") ||args[0].equalsIgnoreCase("junglebush") ||args[0].equalsIgnoreCase("swamp")){
				switch(args[0].toLowerCase()){
				
				case "tree":			player.getWorld().generateTree(player.getLocation(), TreeType.TREE);
										player.sendMessage(ChatColor.GREEN + "Plop!");
										return;
					
				case "birch":			player.getWorld().generateTree(player.getLocation(), TreeType.BIRCH);
										player.sendMessage(ChatColor.GREEN + "Plop!");
										return;
					
				case "redwood":			player.getWorld().generateTree(player.getLocation(), TreeType.REDWOOD);
										player.sendMessage(ChatColor.GREEN + "Plop!");
										return;
								
				case "redmushroom":		player.getWorld().generateTree(player.getLocation(), TreeType.RED_MUSHROOM);
										player.sendMessage(ChatColor.GREEN + "Plop!");
										return;
				
				case "brownmushroom":	player.getWorld().generateTree(player.getLocation(), TreeType.BROWN_MUSHROOM);
										player.sendMessage(ChatColor.GREEN + "Plop!");
										return;
				
				case "jungle":			player.getWorld().generateTree(player.getLocation(), TreeType.SMALL_JUNGLE);
										player.sendMessage(ChatColor.GREEN + "Plop!");
										return;
				
				case "junglebush":		player.getWorld().generateTree(player.getLocation(), TreeType.JUNGLE_BUSH);
										player.sendMessage(ChatColor.GREEN + "Plop!");
										return;
				
				case "swamp":			player.getWorld().generateTree(player.getLocation(), TreeType.SWAMP);
										player.sendMessage(ChatColor.GREEN + "Plop!");
										return;
				}
				
			}else{
				player.sendMessage(ChatColor.RED + "Syntax: /<cmd> <tree|birch|redwood|redmushroom|brownmushroom|jungle|junglebush|swamp>");
				return;
			}
		}else{
			player.sendMessage(ChatColor.RED + "Syntax: /<cmd> <tree|birch|redwood|redmushroom|brownmushroom|jungle|junglebush|swamp>");
			return;
		}
		
		
	}

	
}
