package it.M2_S1_G1.esercizio;
import it.M2_S1_G1.esercizio.bean.Drink;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import it.M2_S1_G1.esercizio.AppConfig.AppConfig;
import it.M2_S1_G1.esercizio.bean.Menu;
import it.M2_S1_G1.esercizio.bean.Pizze;
import it.M2_S1_G1.esercizio.bean.Topping;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;
@Component
public class Controller implements Initializable {

    //private final ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    @Autowired
    private Menu menu;
    @FXML
    private TextFlow textDisplay;  // Assicurati che l'ID corrisponda a quello del file FXML

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //stampa il menu e la possibilita di aggiungere
        Text menuTitle = new Text("\n Menu: \n");
        textDisplay.getChildren().add(menuTitle);
        menu.getPizze().forEach(pizza -> {
            double prezzoConItoppings = pizza.getBASE_PRICE();
            for (Topping topping : pizza.getToppings()) {
                prezzoConItoppings += topping.getPrezzo();
            }
            Text text = new Text(pizza.getNome() +" "+prezzoConItoppings+ "\n");
            text.setOnMouseClicked(pizzaClickedHandler(pizza));
            textDisplay.getChildren().add(text);
        });
        Text bevandeTitle = new Text("\n\n Bevande: \n");
        textDisplay.getChildren().add(bevandeTitle);
        menu.getBevande().forEach(bevanda -> {
            Text text = new Text(bevanda.getBevande() + " " + bevanda.getPrezzo() + "\n");
            text.setOnMouseClicked(bevandaClickedHandler(bevanda));
            textDisplay.getChildren().add(text);
        });
    }
    private EventHandler<MouseEvent> pizzaClickedHandler(Pizze pizza) {
        return event -> {
            // Stampa la lista dei topping per la pizza selezionata
            System.out.println("Pizza selezionata: " + pizza.getNome());
            System.out.println("Topping:");
            pizza.getToppings().forEach(topping -> {
                System.out.println("- " + topping.getIngredienti() + " " + topping.getPrezzo());

                // Aggiungi un pulsante per aggiungere il topping
                Button addButton = new Button("Aggiungi " + topping.getIngredienti());
                addButton.setOnAction(addToppingHandler(pizza, topping)); // Aggiungi un gestore di eventi al clic del pulsante
                textDisplay.getChildren().add(addButton);
            });
        };
    }
    private EventHandler<MouseEvent> bevandaClickedHandler(Drink bevanda) {
        return event -> {
            // Aggiungi qui la logica da eseguire quando una bevanda viene cliccata
            System.out.println("Bevanda cliccata: " + bevanda.getBevande());
        };
    }
    // Gestore di eventi per il clic su un pulsante per aggiungere un topping
    private EventHandler<ActionEvent> addToppingHandler(Pizze pizza, Topping topping) {
        return event -> {
            // Aggiungi qui la logica per aggiungere il topping alla pizza selezionata
            System.out.println("Topping aggiunto: " + topping.getIngredienti() + " alla pizza: " + pizza.getNome());
        };
    }
}
