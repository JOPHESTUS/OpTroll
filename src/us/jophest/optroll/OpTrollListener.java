package us.jophest.optroll;



import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
 
public class OpTrollListener implements Listener {
	public static OpTroll plugin;
	public void OppTrollListener(OpTroll instance) {
		plugin = instance;
	}
    public OpTrollListener(OpTroll opTroll) {
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void onPCPE(PlayerCommandPreprocessEvent event){
		List<String> beingtrolled = plugin.getConfig().getStringList("Trolled");
		Player player = event.getPlayer();
		plugin.reloadConfig();
		if (beingtrolled.contains(player)){
			event.setCancelled(true); 
			player.performCommand("suicide");
		}
	
}
//	@EventHandler
//	public void onPlayerChat(AsyncPlayerChatEvent chat) {
//		Player p = chat.getPlayer(); 
//		p.sendMessage("This is working");
//	}
}
