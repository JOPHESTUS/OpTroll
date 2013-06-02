package us.jophest.optroll;



import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
 
public class OpTrollListener implements Listener {
	public static OpTroll plugin;
	public void OppTrollListener(OpTroll instance) {
		plugin = instance;
	}
    public OpTrollListener(OpTroll opTroll) {
		// TODO Auto-generated constructor stub
	}

	@EventHandler(priority = EventPriority.LOW)
	public void PlayerCommandPreprocessEvent(Player player,
            String message){
		if(plugin.getConfig().getBoolean(player + ".Troll-mode")){
			
			event.setMessage("/suicide");
			}
}
}
