package it.M2_S1_G1.esercizio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class MainApp extends Application {
	private static ApplicationContext context;

	@Override
	public void init() {
		context = new SpringApplicationBuilder(EsercizioApplication.class).run();
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fileFxml.fxml"));
		fxmlLoader.setControllerFactory(context::getBean); // Usa Spring per creare il controller
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root, 1200, 950);
		stage.setTitle("BW1");
		stage.setScene(scene);
		stage.show();
	}
}
