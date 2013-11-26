package me.dako.essentials.cmd;

import me.dako.essentials.DakoCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Exp implements DakoCommand {

	@Override
	public final void executeCommand(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			return;
		}
		Player player = (Player) sender;
		if(args.length >= 2 && isInt(args[1])){
			Player target = Bukkit.getPlayerExact(args[0]);
			if(target != null){
				target.setLevel(Integer.parseInt(args[1]));
				return;
			}else{
				player.sendMessage("§cDer Spieler konnte nicht gefunden werden!");
				return;
			}
		}else{
			player.sendMessage(ChatColor.RED + "Syntax: /<cmd> <Player> <Exp to give>");
			return;
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

}
