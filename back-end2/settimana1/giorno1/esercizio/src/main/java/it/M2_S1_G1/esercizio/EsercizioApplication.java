package it.M2_S1_G1.esercizio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static javafx.application.Application.launch;

@SpringBootApplication
public class EsercizioApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsercizioApplication.class, args);
		// Start JavaFX application
		new Thread(() -> MainApp.launch(MainApp.class, args)).start();
	}
}
