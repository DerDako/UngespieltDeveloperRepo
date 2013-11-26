package me.dako.essentials.cmd;

import me.dako.essentials.DakoCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpAll implements DakoCommand{

	@Override
	public final void executeCommand(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			return;
		}
		
		Player player = (Player) sender;
		Player target = player;
		
		if(args.length >= 1){
			target = Bukkit.getPlayerExact(args[0]);
		}
		
		if(target != null){
			for(Player p: Bukkit.getOnlinePlayers()){
				if(p.getName() != target.getName()){
					p.teleport(target.getLocation());
					p.sendMessage(ChatColor.GREEN + "Du wurdest zu " + target.getName() + " teleportiert!");
				}
			}
			player.sendMessage(ChatColor.GREEN + "Alle Spieler wurden zu " + target.getName() + " teleportiert!");
			return;
		}else{
			player.sendMessage(ChatColor.RED + "Der Spieler ist nicht online!");
			return;
		}
	}
}