package it.epicode.esercizio.appConfig;

import it.epicode.esercizio.EsercizioApplication;
import it.epicode.esercizio.bean.Comanda;
import it.epicode.esercizio.bean.Menu;
import it.epicode.esercizio.bean.Tavolo;
import it.epicode.esercizio.bean.Topping;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(EsercizioApplication.class);
        Menu menu = ctx.getBean(Menu.class);
        System.out.println();
        menu.getAntipasti().forEach(e -> System.out.println(e.getNome() + " - Prezzo: " + e.getPrezzo() + " - Calorie: " + e.getCalorie()));

        System.out.println();
        menu.getBevande().forEach(e -> System.out.println(e.getNome() + " " + "Calorie: " + e.getCalorie() + " " + "Prezzo: " + e.getPrezzo()));

        System.out.println();
        menu.getPizze().forEach(e -> {
            System.out.println(e.getNome());
            System.out.println("Ingredienti: ");
            e.getIngredienti().forEach(i -> System.out.println(i.getNome() + " -Calorie: " + i.getCalorie()));
            System.out.println("Calorie base pizza: " + e.getCalorieBase());
            double calorieTotali = e.getCalorieBase() + e.getIngredienti().stream().mapToInt(Topping::getCalorie).sum();
            System.out.println("Calorie totali: " + calorieTotali);
            System.out.println("Prezzo: " + e.getPrezzoBase());
            System.out.println();
        });

        System.out.println();
        System.out.println(" * 50 cent in più per ogni topping extra* ");
        menu.getTopping().forEach(e -> System.out.println(e.getNome() + " " + "Calorie: " + e.getCalorie()));

        System.out.println("**CONTO TAVOLO 2**");

        Comanda comanda = ctx.getBean(Comanda.class);

        Tavolo tavolo = ctx.getBean(Tavolo.class);

        comanda.contoTotalePerTavolo1(2);
    }
}
