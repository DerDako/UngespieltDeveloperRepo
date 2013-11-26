package me.dako.essentials.cmd;

import me.dako.essentials.DakoCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class WalkSpeed implements DakoCommand, Listener{

	@Override
	public void executeCommand(CommandSender sender, String[] args) {
		
		if(!(sender instanceof Player)){
			return;
		}
		
		Player player = (Player) sender;
		Player target = player;
		
		if(args.length >= 1 && isInt(args[0]) && Integer.valueOf(args[0]) >= -100 && Integer.valueOf(args[0]) <= 100){
			if(args.length >= 2){
				target = Bukkit.getPlayerExact(args[1]);
			}
			
			if(target != null){
				float of = Integer.valueOf(args[0]);
				float f = of/10;
				target.setWalkSpeed(f);
				player.sendMessage(ChatColor.GREEN + "Walk-Speed von " + target.getName() + " auf " + of + " gesetzt!");
				target.sendMessage(ChatColor.GREEN + "Walk-Speed wurde auf " + of + " gesetzt!");
			}
		}else{
			player.setWalkSpeed(0.2f);
			player.sendMessage(ChatColor.GREEN + "Deine Geschwindigkeit wurde resetet(2/0.2f)(-10 - 10).");
		}
	}
	
	public boolean isInt(String string) {
		try {
			Integer.parseInt(string);
		} catch (NumberFormatException nFE) {
			return false;
		}
		return true;
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent event){
		if(event.getPlayer().getWalkSpeed() != 0.2){
			event.getPlayer().setWalkSpeed(0.2f);
		}
	}
	
	@EventHandler
	public void onKick(PlayerKickEvent event){
		if(event.getPlayer().getWalkSpeed() != 0.2){
			event.getPlayer().setWalkSpeed(0.2f);
		}
	}


}
