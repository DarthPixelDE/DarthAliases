package DarthPlugins.DarthAliases;

import java.util.LinkedList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;




public class Kommandos implements CommandExecutor {
	
	private Main p;
	private LinkedList<Alias> befehle;
	
	public Kommandos(Plugin plugin, LinkedList<Alias> Befehlsliste){
		super();
		p = (Main)plugin;
		befehle = Befehlsliste;
		
	}

	//@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(cmd.getName().equalsIgnoreCase("alias")){
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("list")){						
					
					
					
					sender.sendMessage("---------Liste der Aliase---------");
					for(int i =0;i < befehle.size();i++){
						sender.sendMessage(befehle.get(i).toString());						
					}
					
					return true;
				}else if(args[0].equalsIgnoreCase("help")){	
					
				
					
						return false;			
				}
				sender.sendMessage("unbekanntes Argument " + args[0]);
				return false;				
			}else if(args.length > 1){
				if(args[0].charAt(0) == '['){
					if(args[args.length-2].charAt(args[args.length-2].length()-1) == ']'){
						
						String befehl = "", alias = "";
						
						
						befehl = befehl + args[0].substring(1) + " ";
						
						for(int i =1; i <= args.length-3; i++){
							befehl = befehl + args[i] + " ";							
						}
						
						befehl = befehl + args[args.length-2].substring(0, args[args.length-2].length()-1);
						alias = args[args.length-1];
						p.getConfig().set("Befehl." + alias, befehl);
						
						befehle.add(new Alias(alias, befehl));
						String save = "";
						
						for (int i = 0; i < befehle.size(); i++){
							save = save + "/" +  befehle.get(i).getAlias() + ", ";													
						}	
						p.getConfig().set("registrierte_Befehle", save);
						p.saveConfig();
						p.loadConfiguration();						
						p.registerCommand("darthalias.alias." + alias,alias);
						p.pex.getPermissionsManager().getGroup("player").addPermission("darthalias.alias."+alias);
						return true;						
					}else if(args.length > 2){
						if(args[args.length-3].charAt(args[args.length-3].length()-1) == ']'){
							String befehl = "", alias = "", perm = "";
							
							
							befehl = befehl + args[0].substring(1) + " ";
							
							for(int i =1; i <= args.length-4; i++){
								befehl = befehl + args[i] + " ";							
							}
							
							befehl = befehl + args[args.length-3].substring(0, args[args.length-3].length()-1);
							alias = args[args.length-2];
							perm = args[args.length-1];
							p.getConfig().set("Befehl." + alias, befehl);
							
							befehle.add(new Alias(alias, befehl));
							String save = "";
							
							for (int i = 0; i < befehle.size(); i++){
								save = save + "/" +  befehle.get(i).getAlias() + ", ";													
							}	
							p.getConfig().set("registrierte_Befehle", save);
							p.saveConfig();
							p.loadConfiguration();						
							p.registerCommand("darthalias.alias." + alias,alias);
							p.pex.getPermissionsManager().getGroup(perm).addPermission("darthalias.alias."+alias);
							return true;
							
						}
					}
				}
				sender.sendMessage("Falsches Format");
				return false;
			}
			sender.sendMessage("Falsche Anzahl Parameter");
			return false;			
		}
		
		for(int i = 0; i<befehle.size();i++){
			if(cmd.getName().equalsIgnoreCase(befehle.get(i).getAlias())){
				if(sender instanceof Player){
					Player p = (Player)sender;
					p.performCommand(befehle.get(i).getBefehl());
					return true;
				}
				sender.sendMessage("Dieser Befehl ist nur fuer Spieler");
				return true;
			}
		}
		
		
		

		sender.sendMessage("falsch!");
		return false;
		
		
		
	}
}

