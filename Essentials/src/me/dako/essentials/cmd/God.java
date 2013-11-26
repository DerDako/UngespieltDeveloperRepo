package me.dako.essentials.cmd;

import java.util.ArrayList;

import me.dako.essentials.DakoCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class God implements DakoCommand, Listener {
	
	public static ArrayList<String> Players = new ArrayList<String>();
	
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
			if(Players.contains(target.getName())){
				Players.remove(target.getName());
				player.sendMessage(ChatColor.GREEN + "Gott-Modus von " + target.getName() + " deaktiviert!");
				return;
			}else{
				Players.add(target.getName());
				player.sendMessage(ChatColor.GREEN + "Gott-Modus von " + target.getName() + " aktiviert!");
				return;		
			}
		}else{
			player.sendMessage(ChatColor.RED + "Spieler wurde nicht gefunden!");
			return;
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent event){
		if(event.getEntity() instanceof Player){
			Player player = (Player) event.getEntity();
			if(Players.contains(player.getName())){
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onLogout(PlayerQuitEvent event){
		if(Players.contains(event.getPlayer().getName())){
			Players.remove(event.getPlayer().getName());
		}
	}
	
	@EventHandler
	public void onKick(PlayerKickEvent event){
		if(Players.contains(event.getPlayer().getName())){
			Players.remove(event.getPlayer().getName());
		}
	}
}
