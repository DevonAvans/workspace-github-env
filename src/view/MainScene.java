package view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MainScene extends Scene {

	private DatabaseConnectionPane dbp;
	
	public MainScene() {
		super(new Pane(), 500, 500);
		
		createRoot();
	}
	
	private void createRoot() {
		VBox root = new VBox();
		dbp = new DatabaseConnectionPane();
		root.getChildren().add(dbp);
		setRoot(root);
	}

}
