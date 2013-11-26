package me.dako.essentials;

import org.bukkit.command.CommandSender;

public interface DakoCommand{
	
	public void executeCommand(final CommandSender sender, final String[] args);
	
}
