package database;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbconnect {
	private FileConfiguration config;
	private String query;

	public dbconnect(FileConfiguration config) {
		// TODO Auto-generated constructor stub
	}

	public void createTable() {
		// TODO Auto-generated method stub

	}

	public void FirstStart() {
		// TODO Auto-generated method stub
		query = "CREATE TABLE IF NOT EXISTS `"
				+ config.getString("sql.tb_command_poller") + "` ("
				+ "`id` int(10) NOT NULL AUTO_INCREMENT,"
				+ "`name` varchar(30) NOT NULL,"
				+ "`command` varchar(90) NOT NULL," + " `date` date NOT NULL,"
				+ "`intit_date` date NOT NULL,"
				+ "  `init` tinyint(1) NOT NULL," + "  PRIMARY KEY (`id`)"
				+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;"

				+ "CREATE TABLE IF NOT EXISTS `"
				+ config.getString("sql.tb_uptime") + "` ("
				+ "		  `id` int(10) NOT NULL AUTO_INCREMENT,"
				+ "		  `name` varchar(30) NOT NULL,"
				+ "		  `in` date NOT NULL," + "		  `out` date NOT NULL,"
				+ "		  PRIMARY KEY (`id`)"
				+ "		) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;";

		executeQuery();
	}

	private void executeQuery() {
		Connection conn;
		String url = "jdbc:mysql://" + config.getString("sql.host") + ":"
				+ config.getString("sql.port") + "/"
				+ config.getString("sql.db");
		String username = config.getString("sql.user");
		String password = config.getString("sql.pass");

		try {
			// Attempt to connect
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement statement = conn.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
