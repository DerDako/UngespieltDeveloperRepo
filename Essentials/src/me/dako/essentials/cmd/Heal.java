package me.dako.essentials.cmd;

import me.dako.essentials.DakoCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements DakoCommand {

	@Override
	public void executeCommand(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			return;
		}
		
		Player player = (Player) sender;
		Player target = player;
		
		if(args.length >= 1){
			target = Bukkit.getPlayerExact(args[0]);
		}
		if(target != null){
			target.setHealth(20.0);
			player.sendMessage(ChatColor.GREEN + "Du hast " + target.getName() + " geheilt!");
			target.sendMessage(ChatColor.GREEN + "Du wurdest von " + player.getName() + " geheilt!");
			return;
		}else{
			player.sendMessage(ChatColor.RED + "Spieler wurde nicht gefunden!");
			return;
		}
	}

}
