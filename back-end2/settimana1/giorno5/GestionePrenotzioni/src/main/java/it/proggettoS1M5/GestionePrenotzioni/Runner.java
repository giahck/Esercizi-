package it.proggettoS1M5.GestionePrenotzioni;

import it.proggettoS1M5.GestionePrenotzioni.bean.Edificio;
import it.proggettoS1M5.GestionePrenotzioni.bean.Postazione;
import it.proggettoS1M5.GestionePrenotzioni.bean.Prenotazione;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
      //  ApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotzioniApplication.class);
      /*  Postazione postazione1 = ctx.getBean("postazione1", Postazione.class);
        System.out.println(postazione1);*/
    }
}
