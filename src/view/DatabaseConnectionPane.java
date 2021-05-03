package view;


import java.sql.SQLException;
import java.util.ArrayList;

import database.BordDatabase;
import database.DatabaseApplication;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import model.Color;

public class DatabaseConnectionPane extends Pane {

	private BordDatabase bord;
	private ArrayList<Color> c;
	
	public DatabaseConnectionPane(ArrayList<Color> c) {
		this.c = c;
		bord = new BordDatabase();
		Button btn = new Button("test");
		btn.setOnMouseClicked(e -> clicked());
		getChildren().addAll(btn);
	}
	
	private void clicked() {
		try {
			c = bord.test();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
