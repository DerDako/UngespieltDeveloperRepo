package me.dako.essentials.cmd;

import me.dako.essentials.DakoCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenInventory implements DakoCommand{

	@Override
	public void executeCommand(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			return;
		}
		
		Player player = (Player) sender;
		Player target = player;
		
		if(args.length >= 1){
			if(Bukkit.getOnlinePlayers().toString().contains(args[0])||Bukkit.getOfflinePlayers().toString().contains(args[0])){
				target = Bukkit.getPlayerExact(args[0]);
			}else{
				player.sendMessage(ChatColor.RED + "Der Spieler spielte niemals auf diesem Server");
				return;
			}
			
		}
		player.openInventory(target.getInventory());
		return;
	}
	
	

}
