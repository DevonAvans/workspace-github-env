package database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseApplication {

	private static Connection m_Conn;
	private Properties p;

	public DatabaseApplication() {
		m_Conn = null;
		p = new Properties();
		try {
			FileReader reader = new FileReader("resources/config/database.properties");
			p.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean loadDataBaseDriver(String driverName) {
		try {
			// Load the JDBC driver
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// Could not find the database driver
			System.out.println("ClassNotFoundException : " + e.getMessage());
			return false;
		}
		return true;
	}

	public boolean makeConnection() {
		try {
			String s = String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s", p.getProperty("ip"), p.getProperty("port"), p.getProperty("name"), p.getProperty("username"), p.getProperty("password"));
			System.out.println(s);
			m_Conn = DriverManager.getConnection(s);
			System.out.println("So far, so good...");
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("Houston, we've had a problem...");
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return false;
		}
		return true;
	}
	
	public static Connection getCon() {
		return m_Conn;
	}

}
