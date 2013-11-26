package me.dako.essentials;



public enum Commands {
	
	CRASH("crash", new me.dako.essentials.cmd.Crash()),
	FLY("fly", new me.dako.essentials.cmd.Fly()),
	TIME("time", new me.dako.essentials.cmd.TimeSet()),
	BIGTREE("bigtree", new me.dako.essentials.cmd.BigTree()),
	BREAK("break", new me.dako.essentials.cmd.Break()),
	EXP("exp", new me.dako.essentials.cmd.Exp()),
	FEED("feed", new me.dako.essentials.cmd.Feed()),
	GOD("god", new me.dako.essentials.cmd.God()),
	HAT("hat", new me.dako.essentials.cmd.Hat()),
	HEAL("heal", new me.dako.essentials.cmd.Heal()),
	WALKSPEED("walkspeed", new me.dako.essentials.cmd.WalkSpeed()),
	TREE("tree", new me.dako.essentials.cmd.Tree()),
	TORNADO("tornado", new me.dako.essentials.cmd.Tornado()),
	FLYSPEED("flyspeed", new me.dako.essentials.cmd.FlySpeed()),
	WORKBENCH("workbench", new me.dako.essentials.cmd.Workbench()),
	ENDERCHEST("enderchest", new me.dako.essentials.cmd.Enderchest()),
	OPENIVENTORY("openinventory", new me.dako.essentials.cmd.OpenInventory()),
	MUTE("mute", new me.dako.essentials.cmd.Mute()),
	TPALL("tpall", new me.dako.essentials.cmd.TpAll()),
	BUTCHER("butcher", new me.dako.essentials.cmd.Butcher()),
	KILLALL("killall", new me.dako.essentials.cmd.KillAll()),
	WEATHER("weather", new me.dako.essentials.cmd.Weather()),
	BROADCAST("broadcast", new me.dako.essentials.cmd.Broadcast());
	
	
	String cmd;
	DakoCommand executor;
	
	
	private Commands(String CMDName, DakoCommand Executor){
		this.cmd = CMDName;
		this.executor = Executor;
	}
	
	public String CommandName(){
		return this.cmd;
	}
	
	public DakoCommand Executor(){
		return this.executor;
	}
	
	public static Commands[] getCommands(){
		Commands[] ek = {CRASH,FLY,TIME,BIGTREE,BREAK,EXP,FEED,HAT,GOD,HEAL,TREE,TORNADO,FLYSPEED,WALKSPEED,WORKBENCH,ENDERCHEST,OPENIVENTORY,MUTE,TPALL,BUTCHER,KILLALL,WEATHER,BROADCAST};
		return ek;
	}

}
