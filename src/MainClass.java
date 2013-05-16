import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin {

	private static final Logger _log = Logger.getLogger("minecraft");

	@Override
	public void onDisable() {
		_log.info("[dcbilling] Stop");
	}

	@Override
	public void onEnable() {
		_log.info("[dcbilling] Start");
	}

}
