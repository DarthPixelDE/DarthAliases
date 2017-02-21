package DarthPlugins.DarthAliases;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedList;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Main extends JavaPlugin{
	
	private Kommandos executor;
	private LinkedList<Alias> Befehle;
	protected PermissionsEx pex;
	
	
	public void onEnable(){
		
		pex = (PermissionsEx)this.getServer().getPluginManager().getPlugin("PermissionsEx");
		
		
		
		
		Befehle = new LinkedList<Alias>();			
		executor = new Kommandos(this, Befehle);
		
		loadConfiguration();
		
		
		this.getCommand("alias").setExecutor(executor);
		
		
		
				
		
		
		
		
		
		
		
	
			
	}
	
	public void onDisable(){
		
	}

	public void loadConfiguration(){
			
		Befehle.clear();
		
	
		getConfig().options().copyDefaults(true);		
		this.saveConfig();
		
		
		String s = this.getConfig().getString("registrierte_Befehle"), temp = "", befehl = "";
		if(!(s == null)){
			
			for(int i = 0; i < s.length(); i++){
				if(s.charAt(i) == '/'){
					
				}else if(s.charAt(i) == ','){
					befehl = this.getConfig().getString("Befehl." + temp);				
					Befehle.add(new Alias(temp, befehl));
					befehl = "";
					temp = "";
				}else if(s.charAt(i) == ' '){
					
				}else{
					temp = temp + s.charAt(i);
				}
			}
			
			for(int i =0; i < Befehle.size();i++){
				this.registerCommand("darthalias.alias."+Befehle.get(i).getAlias(),Befehle.get(i).getAlias());
				this.getCommand(Befehle.get(i).getAlias()).setExecutor(executor);
			}
		}
		
			
		
	}
	
	
	 
	public void registerCommand(String permission, String... aliases) {
		PluginCommand command = getCommand(aliases[0], this);
		
	 
		command.setAliases(Arrays.asList(aliases));
		command.setPermission(permission);
		getCommandMap().register(this.getDescription().getName(), command);
	}
	 
	private static PluginCommand getCommand(String name, Plugin plugin) {
		PluginCommand command = null;
	 
		try {
			Constructor<PluginCommand> c = PluginCommand.class.getDeclaredConstructor(String.class, Plugin.class);
			c.setAccessible(true);
	 
			command = c.newInstance(name, plugin);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	 
		return command;
	}
	 
	private static CommandMap getCommandMap() {
		CommandMap commandMap = null;
	 
		try {
			if (Bukkit.getPluginManager() instanceof SimplePluginManager) {
				Field f = SimplePluginManager.class.getDeclaredField("commandMap");
				f.setAccessible(true);
	 
				commandMap = (CommandMap) f.get(Bukkit.getPluginManager());
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	 
		return commandMap;
	}
	
	
}
