package me.dako.essentials.cmd;

import java.util.List;

import me.dako.essentials.DakoCommand;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Butcher implements DakoCommand{

	@Override
	public void executeCommand(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			return;
		}
		
		int n = 0;
		Player player = (Player) sender;
		
		int radius = 0;
		if(args.length >= 1){
			if(isInt(args[0])){
				radius = Integer.parseInt(args[0]);
			}else{
				player.sendMessage("Syntax: /<cmd> <radius>");
				return;
			}
		}
		if(radius != 0){
			List<Entity> entities = player.getNearbyEntities(radius, radius, radius);
			for(int i = 0; i < entities.size(); i++){
				Entity ent = entities.get(i);
				if(ent.getType() == EntityType.BLAZE ||ent.getType() == EntityType.CREEPER ||ent.getType() == EntityType.GHAST ||ent.getType() == EntityType.MAGMA_CUBE ||ent.getType() == EntityType.SILVERFISH||ent.getType() == EntityType.SKELETON ||ent.getType() == EntityType.SLIME ||ent.getType() == EntityType.SPIDER ||ent.getType() == EntityType.WITCH||ent.getType() == EntityType.ZOMBIE ||ent.getType() == EntityType.ENDER_DRAGON||ent.getType() == EntityType.WITHER||ent.getType() == EntityType.GIANT ||ent.getType() == EntityType.CAVE_SPIDER ||ent.getType() == EntityType.ENDERMAN ||ent.getType() == EntityType.PIG_ZOMBIE ){
					ent.remove();
					n++;
				}
			}
			
		}else{
			List<Entity> entities = player.getWorld().getEntities();
			for(int i = 0; i < entities.size(); i++){
				Entity ent = entities.get(i);
				if(ent.getType() == EntityType.BLAZE ||ent.getType() == EntityType.CREEPER ||ent.getType() == EntityType.GHAST ||ent.getType() == EntityType.MAGMA_CUBE ||ent.getType() == EntityType.SILVERFISH||ent.getType() == EntityType.SKELETON ||ent.getType() == EntityType.SLIME ||ent.getType() == EntityType.SPIDER ||ent.getType() == EntityType.WITCH||ent.getType() == EntityType.ZOMBIE ||ent.getType() == EntityType.ENDER_DRAGON||ent.getType() == EntityType.WITHER||ent.getType() == EntityType.GIANT ||ent.getType() == EntityType.CAVE_SPIDER ||ent.getType() == EntityType.ENDERMAN ||ent.getType() == EntityType.PIG_ZOMBIE ){
					ent.remove();
					n++;
				}
			}
		}
		player.sendMessage(ChatColor.GREEN + "" + n + " Monster wurde(n) vernichtet");
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
