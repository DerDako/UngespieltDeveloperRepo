package me.dako.essentials.cmd;

import me.dako.essentials.DakoCommand;
import net.minecraft.server.v1_6_R3.EntityPlayer;
import net.minecraft.server.v1_6_R3.Packet24MobSpawn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Crash implements DakoCommand{

	@Override
	public void executeCommand(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			return;
		}
		Player player = (Player) sender;
		if(args.length >= 1){
			Player target = Bukkit.getPlayerExact(args[0]);
			if(target != null){
				EntityPlayer nmsPlayer = ((CraftPlayer) target).getHandle();
				nmsPlayer.playerConnection.sendPacket(new Packet24MobSpawn(nmsPlayer));
				return;
			}else{
				player.sendMessage("§cDer Spieler konnte nicht gefunden werden!");
				return;
			}
		}else{
			player.sendMessage(ChatColor.RED + "Syntax: /<cmd> <Player>");
		}	
	}
}
