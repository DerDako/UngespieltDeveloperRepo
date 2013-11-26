package me.dako.essentials;

import me.McKirby992.minecraft.PluginCommandExecutor;
import me.McKirby992.minecraft.SubPlugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Essentials implements SubPlugin{
	
	private MainExecutor ME;
	
	@Override
	public void onEnable() {
		System.out.println("==================");
		System.out.println("==Dakoessentials==");
		System.out.println("=Loading=Commands=");
		System.out.println("==================");
		registerAllCommands();
		registerEvents();
	}
	
	@Override
	public void onDisable() {

	}
	
	public void registerAllCommands(){
		for(Commands cmds : Commands.getCommands()){
			System.out.println("->Loading Command " + cmds.CommandName() + " in class " + cmds.Executor().toString());
			try{
				ME.Executors.put(cmds.CommandName().toLowerCase(), cmds.Executor());
			}catch(Exception exception){
				System.err.println("=Error=While=Loading=Command: " + cmds.CommandName());
				exception.printStackTrace();
				System.err.println("=========================================");
				return;
			}
		}
		System.out.println("=================");
		System.out.println("=Commands=Loaded=");
		System.out.println("=================");
	}
	
	@Override
    public void registerEvents() {
		new me.dako.essentials.cmd.God();
		new me.dako.essentials.cmd.Fly();
		new me.dako.essentials.cmd.FlySpeed();
		new me.dako.essentials.cmd.WalkSpeed();
		new me.dako.essentials.cmd.Mute();
    }

	@Override
	public PluginCommandExecutor getCommandExecutor() {
		return new MainExecutor();
	}

	@Override
	public String[] getCommandInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCommandPermission() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCommandPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConfigModifyPermission() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEventPermission() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInvalidCommandMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getShortcut() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAccessible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
