package me.dako.essentials.cmd;

import me.dako.essentials.DakoCommand;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Workbench implements DakoCommand{

	@Override
	public void executeCommand(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			return;
		}
		
		Player player = (Player) sender;
		
		player.openWorkbench(null, true);
		
	}
	
	

}
