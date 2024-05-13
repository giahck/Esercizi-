package it.M2_S1_G1.esercizio;


import it.M2_S1_G1.esercizio.AppConfig.AppConfig;
import it.M2_S1_G1.esercizio.bean.Menu;
import javafx.fxml.Initializable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private final ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig .class);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println();
        System.out.println();
        Menu menu = ctx.getBean(Menu.class);
        menu.getPizze().forEach(System.out::println);
        menu.getBevande().forEach(System.out::println);
    }
}
