package me.dako.essentials.cmd;

import java.util.ArrayList;

import me.dako.essentials.DakoCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Tornado implements DakoCommand {

	@SuppressWarnings("deprecation")
	@Override
	public final void executeCommand(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			return;
		}
		
		Player player = (Player) sender;
		
		if(args.length >= 2){
			if(isInt(args[0]) && isInt(args[1])){
				final Material mat;
				
					mat = Material.getMaterial(Integer.parseInt(args[1]));
					if(mat == null){
						player.sendMessage(ChatColor.RED + "ID wurde nicht gefunden!");
						return;
					}
					if(!mat.isBlock()){
						player.sendMessage(ChatColor.RED + "Die ID muss von einem Block sein!");
						return;
					}
				createTornado(player.getLocation(), Integer.parseInt(args[0]) , mat);
			}else{
				player.sendMessage(ChatColor.RED + "Syntax: /<cmd> <duration> <blockID>");
				return;
			}
		}else{
			player.sendMessage(ChatColor.RED + "Syntax: /<cmd> <duration> <blockID>");
			return;
		}
		
	}
	
	public final void createTornado(final Location l, final int duration, final Material blockMaterial) {
		   
	    class VortexBlock {
	       
	        FallingBlock entity;
	       
	        private float ticker_vertical  = 0.0f;
	        private float ticker_horisontal = (float) (Math.random() *  2 * Math.PI);
	       
	        public VortexBlock(Location l) {
	            entity = l.getWorld().spawnFallingBlock(l, blockMaterial, (byte) 0);
	        }
	       
	        public void setVelocity(Vector v) {
	            entity.setVelocity(v);
	        }
	       
	        public float verticalTicker() {
	            if(ticker_vertical < 1.0f) {
	                ticker_vertical += 0.05f;
	            }
	           
	            return ticker_vertical;
	        }
	       
	        public float horisontalTicker() {
	            return (ticker_horisontal += 0.8f);
	        }
	    }
	   
	    final int id = new BukkitRunnable() {
	       
	        private ArrayList<VortexBlock> blocks = new ArrayList<VortexBlock>();
	       
	        public void run() {
	           
	            // Spawns 10 blocks at a the time, with a maximum of 200 blocks at the same time.
	            for(int i = 0 ; i < 10 ; i++) {
	                if(blocks.size() >= 200) {
	                    VortexBlock vb = blocks.get(0);
	                    vb.entity.remove();
	                    blocks.remove(vb);
	                }
	               
	                blocks.add(new VortexBlock(l));
	            }
	           
	            // Makes all of the blocks in the list spin.
	            for(VortexBlock vb : blocks) {
	                double radius = Math.sin(vb.verticalTicker()) * 2;
	               
	                float horisontal = vb.horisontalTicker();
	               
	                vb.setVelocity(new Vector(radius * Math.cos(horisontal), 0.5D, radius * Math.sin(horisontal)));
	            }
	        }
	    }.runTaskTimer(Bukkit.getPluginManager().getPlugin("Essentials"), 5L, 5L).getTaskId();
	   
	    // Stop the "tornado" after 30 "seconds".
	    new BukkitRunnable() {
	        public void run() {
	        	Bukkit.getPluginManager().getPlugin("Essentials").getServer().getScheduler().cancelTask(id);
	        }
	    }.runTaskLater(Bukkit.getPluginManager().getPlugin("Essentials"), 20L * duration);
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
