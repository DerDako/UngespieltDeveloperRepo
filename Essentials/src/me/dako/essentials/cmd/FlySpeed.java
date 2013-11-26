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

public class FlySpeed implements DakoCommand, Listener{

	@Override
	public void executeCommand(CommandSender sender, String[] args) {
		
		if(!(sender instanceof Player)){
			return;
		}
		
		Player player = (Player) sender;
		Player target = player;
		
		if(args.length >= 1 && isInt(args[0]) && Integer.valueOf(args[0]) >= -10 && Integer.valueOf(args[0]) <= 10){
			if(args.length >= 2){
				target = Bukkit.getPlayerExact(args[1]);
			}
			
			if(target != null){
				float of = Integer.valueOf(args[0]);
				float f = of/10;
				target.setFlySpeed(f);
				player.sendMessage(ChatColor.GREEN + "Fly-Speed von " + target.getName() + " auf " + of + " gesetzt!");
				target.sendMessage(ChatColor.GREEN + "Fly-Speed wurde auf " + of + " gesetzt!");
			}
		}else{
			player.setFlySpeed(0.1f);
			player.sendMessage(ChatColor.GREEN + "Deine Flug-Geschwindigkeit wurde resetet(1/0.1f)(-10 - 10).");
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
		if(event.getPlayer().getWalkSpeed() != 0.1f){
			event.getPlayer().setWalkSpeed(0.1f);
		}
	}
	
	@EventHandler
	public void onKick(PlayerKickEvent event){
		if(event.getPlayer().getWalkSpeed() != 0.1f){
			event.getPlayer().setWalkSpeed(0.1f);
		}
	}


}
