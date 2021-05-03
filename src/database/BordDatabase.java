package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Color;

public class BordDatabase extends MainDatabase {

	private ArrayList<Color> colors;
	
	private String colorQuery = "SELECT * FROM color";
	
	public BordDatabase() {
		colors = new ArrayList<Color>();
	}

	public ArrayList<Color> test() throws SQLException {
		ResultSet rs = getResultData(colorQuery);
		while (rs.next()) {
			System.out.println(rs.getString("color"));
			colors.add(new Color(rs.getString("color")));
		}
		rs.close();
		return colors;
	}

}
