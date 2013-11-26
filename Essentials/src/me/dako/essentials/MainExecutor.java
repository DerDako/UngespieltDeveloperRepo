package me.dako.essentials;

import java.util.HashMap;

import me.McKirby992.minecraft.PluginCommandExecutor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainExecutor implements PluginCommandExecutor{
	
	public static HashMap<String, DakoCommand> Executors = new HashMap<String, DakoCommand>();
		

	@Override
	public void executeCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
			
		if(Executors.containsKey(cmd.getName().toLowerCase())){
			if(sender.hasPermission("dessentials." + cmd.getName().toLowerCase())){
				DakoCommand executor = Executors.get(cmd.getName().toLowerCase());
				executor.executeCommand(sender, args);
				return;
			}else{
				sender.sendMessage("§cDu bist nicht berechtigt dies zu tun!");
				return;
			}
		}	
	}
}
