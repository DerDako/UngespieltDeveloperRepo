package me.dako.essentials.cmd;

import me.dako.essentials.DakoCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements DakoCommand{

	@Override
	public void executeCommand(CommandSender sender, String[] args) {
		if(args.length >= 1 ){
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < args.length; i++){
				sb.append(args[i]);
			}
			String message = sb.toString();
			ChatColor.translateAlternateColorCodes('&', message);
			for(Player target: Bukkit.getOnlinePlayers()){
				target.sendMessage(message);
			}
		}
		
	}

	
}
