package controller;

import database.DatabaseApplication;
import javafx.application.Application;
import javafx.stage.Stage;
import view.MainScene;

public class Controller extends Application {
	
	public void startup(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		new DatabaseApplication().makeConnection();
		stage.setTitle("Project test env");
		stage.setScene(new MainScene());
		stage.show();
	}

}
