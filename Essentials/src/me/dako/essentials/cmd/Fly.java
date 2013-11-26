package me.dako.essentials.cmd;

import java.util.ArrayList;

import me.dako.essentials.DakoCommand;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Fly implements DakoCommand, Listener{
	
	ArrayList<String> Flying = new ArrayList<String>(); 

	@Override
	public void executeCommand(CommandSender sender, String[] args) {
		
		if(!(sender instanceof Player)){
			return;
		}
		Player player = (Player) sender;
		
		Player target = player;
		if(args .length == 1){
			target = Bukkit.getPlayer(args[0]);
		}
		if(target != null){
			if(!Flying.contains(target.getName())){
				target.setAllowFlight(true);
				target.setFlying(true);
				Flying.add(target.getName());
				return;
			}else{
				target.setAllowFlight(false);
				target.setFlying(false);
				Flying.remove(target.getName());
			}
		}else{
			player.sendMessage("§cSpieler wurde nicht gefunden.");
			return;
		}
	}
	
	@EventHandler
	public void onLogout(PlayerQuitEvent event){
		if(Flying.contains(event.getPlayer().getName())){
			Flying.remove(event.getPlayer().getName());
		}
	}
	
	@EventHandler
	public void onKick(PlayerKickEvent event){
		if(Flying.contains(event.getPlayer().getName())){
			Flying.remove(event.getPlayer().getName());
		}
	}
}