package it.M2_S1_G1.esercizio.AppConfig;

import it.M2_S1_G1.esercizio.EnumS.EnumBevande;
import it.M2_S1_G1.esercizio.EnumS.EnumFormatoPizza;
import it.M2_S1_G1.esercizio.EnumS.EnumIngredienti;
import it.M2_S1_G1.esercizio.bean.Drink;
import it.M2_S1_G1.esercizio.bean.Menu;
import it.M2_S1_G1.esercizio.bean.Pizze;
import it.M2_S1_G1.esercizio.bean.Topping;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public Menu menu() {
        Menu menu = new Menu(getPizze(), getBevande());
        // Stampa di debug
        System.out.println("Menu created with Pizze: " + menu.getPizze());
        System.out.println("Menu created with Bevande: " + menu.getBevande());
        return menu;
    }

    @Bean
    public List<Drink> getBevande() {
        return List.of(
                new Drink(EnumBevande.COCA_ZERO, EnumBevande.COCA_ZERO.getPrezzo()),
                new Drink(EnumBevande.ACQUA, EnumBevande.ACQUA.getPrezzo()),
                new Drink(EnumBevande.COCA, EnumBevande.COCA.getPrezzo()),
                new Drink(EnumBevande.BIRRA, EnumBevande.BIRRA.getPrezzo()),
                new Drink(EnumBevande.CHINOTTO, EnumBevande.CHINOTTO.getPrezzo()),
                new Drink(EnumBevande.FANTA, EnumBevande.FANTA.getPrezzo()),
                new Drink(EnumBevande.SPRITE, EnumBevande.SPRITE.getPrezzo()),
                new Drink(EnumBevande.THE, EnumBevande.THE.getPrezzo()),
                new Drink(EnumBevande.CAFFE, EnumBevande.CAFFE.getPrezzo())
        );
    }
    //singolo bean con costruttore vuoto
    @Bean
    public Drink getBevande2() {
        
        Drink drink = new Drink();
        drink.setBevande(EnumBevande.COCA_ZERO);
        drink.setPrezzo(EnumBevande.COCA_ZERO.getPrezzo());

        return drink;

    }

    @Bean
    public List<Pizze> getPizze() {
        return List.of(
                new Pizze("Margherita", EnumFormatoPizza.MEDIA, List.of(
                        new Topping(EnumIngredienti.BASILICO, EnumIngredienti.BASILICO.getPrezzo()),
                        new Topping(EnumIngredienti.POMODORO, EnumIngredienti.POMODORO.getPrezzo()),
                        new Topping(EnumIngredienti.MOZZARELLABUFALA, EnumIngredienti.MOZZARELLABUFALA.getPrezzo())
                )),
                new Pizze("Fiori e Alici", EnumFormatoPizza.MEDIA, List.of(
                        new Topping(EnumIngredienti.ALICI, EnumIngredienti.ALICI.getPrezzo()),
                        new Topping(EnumIngredienti.FIORI, EnumIngredienti.FIORI.getPrezzo()),
                        new Topping(EnumIngredienti.MOZZARELLABUFALA, EnumIngredienti.MOZZARELLABUFALA.getPrezzo())
                )),
                new Pizze("Capricciosa", EnumFormatoPizza.MEDIA, List.of(
                        new Topping(EnumIngredienti.FUNGHI, EnumIngredienti.FUNGHI.getPrezzo()),
                        new Topping(EnumIngredienti.POMODORO, EnumIngredienti.POMODORO.getPrezzo()),
                        new Topping(EnumIngredienti.MOZZARELLA, EnumIngredienti.MOZZARELLA.getPrezzo()),
                        new Topping(EnumIngredienti.SALSICCIA, EnumIngredienti.SALSICCIA.getPrezzo()),
                        new Topping(EnumIngredienti.PROSCIUTTO, EnumIngredienti.PROSCIUTTO.getPrezzo()),
                        new Topping(EnumIngredienti.CARCIOFI, EnumIngredienti.CARCIOFI.getPrezzo())
                )),
                new Pizze("Napoli", EnumFormatoPizza.MEDIA, List.of(
                        new Topping(EnumIngredienti.BASILICO, EnumIngredienti.BASILICO.getPrezzo()),
                        new Topping(EnumIngredienti.POMODORO, EnumIngredienti.POMODORO.getPrezzo()),
                        new Topping(EnumIngredienti.MOZZARELLABUFALA, EnumIngredienti.MOZZARELLABUFALA.getPrezzo())
                ))
        );
    }
}
