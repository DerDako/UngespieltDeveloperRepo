package me.dako.essentials.cmd;

import me.dako.essentials.DakoCommand;

import org.bukkit.ChatColor;
import org.bukkit.TreeType;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BigTree implements DakoCommand{

	@Override
	public void executeCommand(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			return;
		}
		
		Player player = (Player) sender;
		
		if(args.length >= 1){
			if(args[0].equalsIgnoreCase("tree") || args[0].equalsIgnoreCase("redwood") || args[0].equalsIgnoreCase("jungle")){
				switch(args[0].toLowerCase()){
				
				case "tree":	player.getWorld().generateTree(player.getLocation(), TreeType.BIG_TREE);
								player.sendMessage(ChatColor.GREEN + "Plop!");
								return;
					
				case "redwood":	player.getWorld().generateTree(player.getLocation(), TreeType.TALL_REDWOOD);
								player.sendMessage(ChatColor.GREEN + "Plop!");
								return;
					
				case "jungle":	player.getWorld().generateTree(player.getLocation(), TreeType.JUNGLE);
								player.sendMessage(ChatColor.GREEN + "Plop!");
								return;
				
				}
				
			}else{
				player.sendMessage(ChatColor.RED + "Syntax: /<cmd> <tree|redwood|jungle>");
			}
		}else{
			player.sendMessage(ChatColor.RED + "Syntax: /<cmd> <tree|redwood|jungle>");
		}
		
	}
	

}
