package it.proggettoS1M5.GestionePrenotzioni.appConfig;

import it.proggettoS1M5.GestionePrenotzioni.Enum.EnumPostazione;
import it.proggettoS1M5.GestionePrenotzioni.Repository.PostazioneRepository;
import it.proggettoS1M5.GestionePrenotzioni.Repository.PrenotazioneRepository;
import it.proggettoS1M5.GestionePrenotzioni.Repository.UtenteRepository;
import it.proggettoS1M5.GestionePrenotzioni.bean.Postazione;
import it.proggettoS1M5.GestionePrenotzioni.bean.Prenotazione;
import it.proggettoS1M5.GestionePrenotzioni.bean.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    @Autowired
    private PostazioneRepository postazioneRepository;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Bean("postazione1")
    public Postazione postazione1(@Value("${edificio1.nome}") String nome, @Value("${edificio1.indirizzo}") String indirizzo, @Value("${edificio1.citta}") String citta) {

        System.out.println(nome + " " + indirizzo + " " + citta);
        Postazione postazione = Postazione.builder()
                .nome(nome).indirizzo(indirizzo).citta(citta).id(UUID.randomUUID()).descrizione("Room Coffi")
                .tipo(EnumPostazione.OPENSPACE).maxPosti(20).build();
        postazioneRepository.save(postazione);
        return postazione;
    }

    @Bean("postazione2")
    public Postazione postazione2(@Value("${edificio2.nome}") String nome, @Value("${edificio2.indirizzo}") String indirizzo, @Value("${edificio2.citta}") String citta) {
        Postazione postazione = Postazione.builder()
                .nome(nome).indirizzo(indirizzo).citta(citta).id(UUID.randomUUID()).descrizione("Sala Stampa")
                .tipo(EnumPostazione.SALA_RIUNIONI).maxPosti(50).build();
        postazioneRepository.save(postazione);
        return postazione;
    }

    @Bean("postazione3")
    public Postazione postazione3(@Value("${edificio3.nome}") String nome, @Value("${edificio3.indirizzo}") String indirizzo, @Value("${edificio3.citta}") String citta) {
        Postazione postazione = Postazione.builder()
                .nome(nome).indirizzo(indirizzo).citta(citta).id(UUID.randomUUID()).descrizione("Sala game LAN")
                .tipo(EnumPostazione.PRIVATO).maxPosti(5).build();
        postazioneRepository.save(postazione);
        return postazione;
    }

    @Bean("postazione4")
    public Postazione postazione4(@Value("${edificio2.nome}") String nome, @Value("${edificio2.indirizzo}") String indirizzo, @Value("${edificio2.citta}") String citta) {
        Postazione postazione = Postazione.builder()
                .nome(nome).indirizzo(indirizzo).citta(citta).id(UUID.randomUUID()).descrizione("Sala Conference a1")
                .tipo(EnumPostazione.SALA_RIUNIONI).maxPosti(35).build();
        postazioneRepository.save(postazione);
        return postazione;
    }

    @Bean("postazione5")
    public Postazione postazione5(@Value("${edificio3.nome}") String nome, @Value("${edificio3.indirizzo}") String indirizzo, @Value("${edificio1.citta}") String citta) {
        Postazione postazione = Postazione.builder()
                .nome(nome).indirizzo(indirizzo).citta(citta).id(UUID.randomUUID()).descrizione("Room Db1")
                .tipo(EnumPostazione.PRIVATO).maxPosti(10).build();
        postazioneRepository.save(postazione); //se non controllo nel runner mi duplica se istanzio  ctx
        return postazione;
    }
    @Bean("utente1")
    public Utente utente() {
        Utente utente= Utente.builder().nome(List.of(new String[]{"Mario", "Rossi"})).email("dfcs@cd.com").Username("MaRoss").build();
        utenteRepository.save(utente);
        return utente;
    } @Bean("utente2")
    public Utente utente2() {
        Utente utente= Utente.builder().nome(List.of(new String[]{"Giovanni", "Quarto"})).email("dfcs@cd.com").Username("Giovquarz").build();
        utenteRepository.save(utente);
        return utente;
    } @Bean("utente3")
    public Utente utente3() {
        Utente utente= Utente.builder().nome(List.of(new String[]{"Ugo", "Foscolo"})).email("dfcs@cd.com").Username("fosUg").build();
        utenteRepository.save(utente);
        return utente;
    }

    @Bean("Prenotazione1")
    public Prenotazione prenotazione1(@Qualifier("utente1")Utente utente, @Qualifier("postazione1")Postazione postazione){
        Prenotazione prenotazione = Prenotazione.builder()
                .data(LocalDate.of(2023,5,5)).postazione(postazione).utente(utente).build();
        prenotazioneRepository.save(prenotazione);
        return prenotazione;
    }    @Bean("Prenotazione2")
    public Prenotazione prenotazione2(@Qualifier("utente2")Utente utente, @Qualifier("postazione2")Postazione postazione){
        Prenotazione prenotazioneEsistente = prenotazioneRepository.findPrenotazioneByPostazioneAndData(postazione.getId(), LocalDate.of(2023,8,20));
        if (prenotazioneEsistente != null)
            throw new RuntimeException("La postazione è già stata assegnata per il giorno selezionato.");

        Prenotazione prenotazione = Prenotazione.builder()
                .data(LocalDate.of(2023,8,20)).postazione(postazione).utente(utente).build();
        prenotazioneRepository.save(prenotazione);
        return prenotazione;
    }    @Bean("Prenotazione3")
    public Prenotazione prenotazione3(@Qualifier("utente3")Utente utente, @Qualifier("postazione3")Postazione postazione){
        Prenotazione prenotazione = Prenotazione.builder()
                .data(LocalDate.of(2024,2,11)).postazione(postazione).utente(utente).build();
        prenotazioneRepository.save(prenotazione);
        return prenotazione;
    }    @Bean("Prenotazione4")
    public Prenotazione prenotazione4(@Qualifier("utente2")Utente utente, @Qualifier("postazione4")Postazione postazione){
        Prenotazione prenotazione = Prenotazione.builder()
                .data(LocalDate.of(2024,8,5)).postazione(postazione).utente(utente).build();
        prenotazioneRepository.save(prenotazione);
        return prenotazione;
    }    @Bean("Prenotazione5")
    public Prenotazione prenotazione5(@Qualifier("utente1")Utente utente, @Qualifier("postazione5")Postazione postazione){
        Prenotazione prenotazione = Prenotazione.builder()
                .data(LocalDate.of(2023,9,5)).postazione(postazione).utente(utente).build();
        prenotazioneRepository.save(prenotazione);
        return prenotazione;
    }   /* @Bean("Prenotazione6")
    public Prenotazione prenotazione6(@Qualifier("utente3")Utente utente, @Qualifier("postazione1")Postazione postazione){
        Prenotazione prenotazioneEsistente = prenotazioneRepository.findPrenotazioneByPostazioneAndData(postazione.getId(), LocalDate.of(2023,5,5));
        Prenotazione prenotazione = Prenotazione.builder()
                .data(LocalDate.of(2023,5,5)).postazione(postazione).utente(utente).build();
        if (prenotazioneEsistente != null)
            throw new RuntimeException("La postazione è già stata assegnata per il giorno selezionato.");
        else {
        prenotazioneRepository.save(prenotazione);}
        return prenotazione;
    }*/


}
