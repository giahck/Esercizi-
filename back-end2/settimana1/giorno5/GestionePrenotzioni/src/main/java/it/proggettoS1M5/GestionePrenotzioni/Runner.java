package it.proggettoS1M5.GestionePrenotzioni;

import it.proggettoS1M5.GestionePrenotzioni.Enum.EnumPostazione;
import it.proggettoS1M5.GestionePrenotzioni.bean.Edificio;
import it.proggettoS1M5.GestionePrenotzioni.bean.Postazione;
import it.proggettoS1M5.GestionePrenotzioni.bean.Prenotazione;
import it.proggettoS1M5.GestionePrenotzioni.service.PostazioneService;
import it.proggettoS1M5.GestionePrenotzioni.service.PrenootazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Autowired//se no mi cicla due volte il metodo run
    private ApplicationContext ctx;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private PrenootazioneRepository prenotazioneRepository;
    @Override
    public void run(String... args) throws Exception {
       // ApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotzioniApplication.class);
        /*Postazione postazione1 = ctx.getBean("postazioni", Postazione.class);
        System.out.println(postazione1);*/
        //ricerca postazione per citta e tipo
        System.out.println("ok");
        //query per trovare postazioni per citta e tipo
        List<Postazione> postazioni = postazioneService.getPostazioniByCittaAndTipo("Roma", EnumPostazione.OPENSPACE);
        postazioni.forEach(System.out::println);
        //query un utente quante prenotazzioni ha
        System.out.println(prenotazioneRepository.getPrenotazioniCountByUsername("MaRoss"));
    }
}
