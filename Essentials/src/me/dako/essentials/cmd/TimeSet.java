package me.dako.essentials.cmd;

import me.dako.essentials.DakoCommand;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TimeSet implements DakoCommand{

	@Override
	public void executeCommand(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage("Nur Spieler können dies tun!");
			return;
		}
		Player player = (Player) sender;
		if(player.hasPermission("dessentials.time")){
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("day") || args[0].equalsIgnoreCase("night") || args[0].equalsIgnoreCase("evening") || args[0].equalsIgnoreCase("noon")){
					switch(args[0]){
					case "day":		player.getWorld().setTime(0);
									player.sendMessage("Die Zeit wurde auf §b0 §fticks in der Welt: §b" + player.getWorld().getName() + " §fgesetzt!");
									return;
								
					case "night":	player.getWorld().setTime(18000);
									player.sendMessage("Die Zeit wurde auf §b18000 §fticks in der Welt: §b" + player.getWorld().getName() + " §fgesetzt!");
									return;
								
					case "evening":	player.getWorld().setTime(12000);
									player.sendMessage("Die Zeit wurde auf §b12000 §fticks in der Welt: §b" + player.getWorld().getName() + " §fgesetzt!");
									Item item = player.getWorld().dropItem(player.getEyeLocation(), new ItemStack(Material.SAND)); 
									item.setVelocity(player.getLocation().getDirection().multiply(2));
									item.setPickupDelay(200);
									return;
								
					case "noon":	player.getWorld().setTime(6000);
									player.sendMessage("Die Zeit wurde auf §b6000 §fticks in der Welt: §b" + player.getWorld().getName() + " §fgesetzt!");
									return;
					}
				}else{
					player.sendMessage("§cSyntax: /<cmd> <day|night|evening|noon>");
				}
			}else{
				player.sendMessage("§cSyntax: /<cmd> <day|night|evening|noon>");
			}
		}else{
			player.sendMessage("§cDu bist nicht berechtigt dies zu tun!");
			return;
		}
		
	}
	
	

}
