package us.jophest.optroll;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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

	public void HappyBirthdayHawkFalcon(){
		
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
			List<String> beingtrolled = getConfig().getStringList("Trolled");
			if (sender.hasPermission("optroll.trollmaster")){
				if (!trolled.hasPermission("optroll.immmune")){
					if(beingtrolled.contains(trolled.getName())){
						beingtrolled.remove(trolled);
						saveConfig();
						reloadConfig();
						
						
						
						
					}
					else {
						beingtrolled.add(trolled.getName());
						getConfig().set("Trolled", beingtrolled);
						saveConfig();
						reloadConfig();
						sender.sendMessage(ChatColor.BLUE + "" + trolled.getName() + " will now be 'OpTrolled'");
					}
				}else{
					
				
				sender.sendMessage(ChatColor.BLUE + "Error: That player is immune");
					
			}
			
			
		}else{
			sender.sendMessage(ChatColor.BLUE + "Error: You don't have permission");
		}
		
		
		
	}
		return false;
	}
}

	
	
	
	

	
	
	
	
	
	
	
