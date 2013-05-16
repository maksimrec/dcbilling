import java.util.logging.Logger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import database.dbconnect;

public class MainClass extends JavaPlugin {

	private static final Logger _log = Logger.getLogger("minecraft");
	private dbconnect query;
	
	
	@Override
	public void onDisable() {
		_log.info("[billing] Stop");
	}

	@Override
	public void onEnable() {
		 this.saveDefaultConfig();
		 
		 query = new dbconnect(this.getConfig());
		 if (this.getConfig().getBoolean("first-start")) {
			 _log.info("[billing] Creating DB columns...");
	            query.FirstStart();
	            this.getConfig().set("first-start", false);
	            this.saveConfig();
	            _log.info("[billing] Success!");
	        }
		
		_log.info("[billing] Start");
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
			}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		
	}

}
