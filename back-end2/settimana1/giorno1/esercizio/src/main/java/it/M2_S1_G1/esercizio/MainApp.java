package it.M2_S1_G1.esercizio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fileFxml.fxml"));
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root, 900, 600);
		stage.setTitle("BW1");
		stage.setScene(scene);
		stage.show();
	}
}
