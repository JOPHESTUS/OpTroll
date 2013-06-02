package us.jophest.optroll;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class OpTroll extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	PluginDescriptionFile pdfFile;
	public static OpTroll plugin;
	 public final OpTrollListener Listener = new OpTrollListener(this);


	public void onEnable() {
		SetupConfig();
		getServer().getPluginManager().registerEvents(Listener, this);
	}


	private void SetupConfig() {
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (command.getName().equalsIgnoreCase("optroll")){
			Player trolled = Bukkit.getServer().getPlayer(args[0]);
			if (sender.hasPermission("optroll.trollmaster")){
				if (!trolled.hasPermission("optroll.immmune")){
					if(getConfig().getBoolean(trolled + ".Troll-mode")){
						getConfig().set(trolled + ".Troll-mode", false);
						saveConfig();
						reloadConfig();
						
						
					}
					else {
						getConfig().set(trolled + ".Troll-mode", true);
					}
				}
					
			}
		}
		
		return true;
		
	}
	
	
			
		
	}
	
	
	
	
	
	
	
