package me.dako.essentials.cmd;

import me.dako.essentials.DakoCommand;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Weather implements DakoCommand {

	@Override
	public void executeCommand(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			return;
		}
		
		Player player = (Player) sender;
		
		if(args.length >= 1){
			switch(args[0].toLowerCase()){
			
			case "sun":		player.getWorld().setWeatherDuration(0);
							player.sendMessage(ChatColor.GREEN + "Wetter erfolgreich gewechselt!");
							return;
						
			case "rain":	player.getWorld().setThunderDuration(0);
							player.getWorld().setThundering(false);
							player.getWorld().setStorm(false);
							player.sendMessage(ChatColor.GREEN + "Wetter erfolgreich gewechselt!");
							return;
							
			case "thunder":	player.getWorld().setThundering(true);
							player.getWorld().setStorm(false);
							player.sendMessage(ChatColor.GREEN + "Wetter erfolgreich gewechselt!");
							return;
			}
			player.sendMessage(ChatColor.RED + "Syntax: /<cmd> <sun|rain|storm>");
			return;
		}
		player.sendMessage(ChatColor.RED + "Syntax: /<cmd> <sun|rain|storm>");
		return;
	}
	
	

}
