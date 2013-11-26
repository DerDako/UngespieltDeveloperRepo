package me.dako.essentials.cmd;

import java.util.ArrayList;

import me.dako.essentials.DakoCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

public class Mute implements DakoCommand, Listener {
	
	static boolean gMute = false;
	static ArrayList<String> muted = new ArrayList<String>();
	
	@Override
	public void executeCommand(CommandSender sender, String[] args) {
		
		if(!(sender instanceof Player)){
			return;
		}
		
		Player player = (Player) sender;
		
		if(args.length >= 1){
			if(args.length >= 2 && args[0].equalsIgnoreCase("-") && args[1].equalsIgnoreCase("global")){
				if(!gMute){
					gMute = true;
					player.sendMessage(ChatColor.GREEN + "Du hast den server Global gemutet! Nur Spieler mit der /mute permission können noch schreiben!");
					Bukkit.getServer().broadcastMessage(ChatColor.DARK_AQUA + "Der Chat wurde von " + player.getName() + " deaktiviert!");
				}else{
					gMute = false;
					player.sendMessage(ChatColor.GREEN + "Du hast den server Global entmutet!");
					Bukkit.getServer().broadcastMessage(ChatColor.DARK_AQUA + "Der Chat wurde von " + player.getName() + " aktiviert!");
				}
		}else{
			Player target = Bukkit.getPlayerExact(args[0]);
			if(muted.contains(target.getName())){
				if(target != null){
					player.sendMessage(ChatColor.GREEN + "Du hast " + target.getName() + " entmutet!");
					target.sendMessage(ChatColor.RED + "Du wurdest von " + player.getName() + " entmutet!");
					muted.remove(target.getName());
					return;
				}else{
					player.sendMessage(ChatColor.RED + "Der Spieler wurde nicht gefunden");
					return;
					}
				}else{
					if(target != null){
						player.sendMessage(ChatColor.GREEN + "Du hast " + target.getName() + " gemutet!");
						target.sendMessage(ChatColor.RED + "Du wurdest von " + player.getName() + " gemutet!");
						muted.add(target.getName());
						return;
					}else{
						player.sendMessage(ChatColor.RED + "Der Spieler wurde nicht gefunden");
						return;
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event){
		if(muted.contains(event.getPlayer().getName())){
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "Du bist gemutet!");
			return;
		}
		if(gMute){
			if(!event.getPlayer().hasPermission("dessentials.mute")){
				event.setCancelled(true);
				event.getPlayer().sendMessage(ChatColor.RED + "Der Server ist Global gemutet");
				return;
			}
		}
	}
}