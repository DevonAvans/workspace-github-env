package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainDatabase {
	
	private Connection m_Conn;
	
	public MainDatabase() {
		m_Conn = DatabaseApplication.getCon();
	}

	protected int getRows(String query) {

		return 1;
	}
	
	protected ResultSet getResultData(String query) {
		Statement stmt = null;
//		String query = "SELECT * FROM color";
		try {
			stmt = m_Conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
//			while (rs.next()) {
//				System.out.println(rs.getString("color"));
//			}
//			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
}
