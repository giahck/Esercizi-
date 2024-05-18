package it.proggettoS1M5.GestionePrenotzioni.appConfig;

import it.proggettoS1M5.GestionePrenotzioni.Enum.EnumPostazione;
import it.proggettoS1M5.GestionePrenotzioni.Repository.PostazioneRepository;
import it.proggettoS1M5.GestionePrenotzioni.Repository.PrenotazioneRepository;
import it.proggettoS1M5.GestionePrenotzioni.Repository.UtenteRepository;
import it.proggettoS1M5.GestionePrenotzioni.bean.Postazione;
import it.proggettoS1M5.GestionePrenotzioni.bean.Prenotazione;
import it.proggettoS1M5.GestionePrenotzioni.bean.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
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

    @Bean
    public List<Postazione> postazioni(@Value("${edificio1.nome}") String nome1, @Value("${edificio1.indirizzo}") String indirizzo1, @Value("${edificio1.citta}") String citta1,
                                       @Value("${edificio2.nome}") String nome2, @Value("${edificio2.indirizzo}") String indirizzo2, @Value("${edificio2.citta}") String citta2,
                                       @Value("${edificio3.nome}") String nome3, @Value("${edificio3.indirizzo}") String indirizzo3, @Value("${edificio3.citta}") String citta3,
                                       @Value("${edificio4.nome}") String nome4, @Value("${edificio4.indirizzo}") String indirizzo4, @Value("${edificio4.citta}") String citta4) {
        return List.of(
                createPostazione(nome1, indirizzo1, citta1, "Room Coffi", EnumPostazione.OPENSPACE, 20),
                createPostazione(nome2, indirizzo2, citta2, "Sala Stampa", EnumPostazione.SALA_RIUNIONI, 50),
                createPostazione(nome3, indirizzo3, citta3, "Sala game LAN", EnumPostazione.PRIVATO, 5),
                createPostazione(nome2, indirizzo2, citta2, "Sala Conference a1", EnumPostazione.SALA_RIUNIONI, 35),
                createPostazione(nome3, indirizzo3, citta3, "Room Db1", EnumPostazione.PRIVATO, 10)
        );
    }

    private Postazione createPostazione(String nome, String indirizzo, String citta, String descrizione, EnumPostazione tipo, int maxPosti) {
        Postazione postazione = Postazione.builder()
                .nome(nome).indirizzo(indirizzo).citta(citta).id(UUID.randomUUID()).descrizione(descrizione).tipo(tipo).maxPosti(maxPosti).build();
        // return postazioneRepository.save(postazione);
        return postazione;
    }

    @Bean
    public List<Utente> utenti() {
        return List.of(
                createUtente("Mario", "Rossi", "dfcs@cd.com", "MaRoss"),
                createUtente("Giovanni", "Quarto", "dfcs@cd.com", "Giovquarz"),
                createUtente("Ugo", "Foscolo", "dfcs@cd.com", "fosUg")
        );
    }

    private Utente createUtente(String nome, String cognome, String email, String username) {
        Utente utente = Utente.builder().nome(List.of(nome, cognome)).email(email).username(username).build();
        // return utenteRepository.save(utente);
        return utente;
    }

    @Bean
    @DependsOn("postazioni")
    @Transactional
    public List<Optional<Prenotazione>> prenotazioni(List<Utente> utenti, List<Postazione> postazioni) {
        return List.of(
                createPrenotazione(utenti.get(0), postazioni.get(0), LocalDate.of(2023, 5, 5)),
                createPrenotazione(utenti.get(1), postazioni.get(1), LocalDate.of(2023, 8, 20)),
                createPrenotazione(utenti.get(2), postazioni.get(2), LocalDate.of(2024, 2, 11)),
                createPrenotazione(utenti.get(1), postazioni.get(3), LocalDate.of(2024, 8, 5)),
                createPrenotazione(utenti.get(0), postazioni.get(4), LocalDate.of(2023, 9, 5)),
                createPrenotazione(utenti.get(2), postazioni.get(0), LocalDate.of(2023, 5, 5))
        );
    }

    private Optional<Prenotazione> createPrenotazione(Utente utente, Postazione postazione, LocalDate data) {
        Prenotazione prenotazioneEsistente = prenotazioneRepository.findPrenotazioneByPostazioneAndData(postazione.getId(), data);
        if (prenotazioneEsistente != null) {
            System.out.println("La postazione è già stata assegnata per il giorno selezionato.");
            return Optional.empty();
        } else {
            Prenotazione prenotazione = Prenotazione.builder()
                    .data(data)
                    .postazione(postazione)
                    .utente(utente)
                    .build();
            // return Optional.of(prenotazioneRepository.save(prenotazione));
            return Optional.of(prenotazione);
        }
    }
}



//********************************************************************************************************************
// metodo con i builder per creare le postazioni, gli utenti e le prenotazioni funzionante
/*@Configuration
@PropertySource("application.properties")
public class AppConfig {
    @Autowired
    private PostazioneRepository postazioneRepository;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    //------------------------------CREAZIONE POSTAZIONI--------------------------------
    @Bean("postazione1")
    public Postazione postazione1(@Value("${edificio1.nome}") String nome, @Value("${edificio1.indirizzo}") String indirizzo, @Value("${edificio1.citta}") String citta) {

        System.out.println(nome + " " + indirizzo + " " + citta);
        Postazione postazione = Postazione.builder()
                .nome(nome).indirizzo(indirizzo).citta(citta).id(UUID.randomUUID()).descrizione("Room Coffi")
                .tipo(EnumPostazione.OPENSPACE).maxPosti(20).build();
        System.out.println(postazione.getId());

        return postazioneRepository.save(postazione);
    }

    @Bean("postazione2")
    public Postazione postazione2(@Value("${edificio2.nome}") String nome, @Value("${edificio2.indirizzo}") String indirizzo, @Value("${edificio2.citta}") String citta) {
        Postazione postazione = Postazione.builder()
                .nome(nome).indirizzo(indirizzo).citta(citta).id(UUID.randomUUID()).descrizione("Sala Stampa")
                .tipo(EnumPostazione.SALA_RIUNIONI).maxPosti(50).build();
        return postazioneRepository.save(postazione);
    }

    @Bean("postazione3")
    public Postazione postazione3(@Value("${edificio3.nome}") String nome, @Value("${edificio3.indirizzo}") String indirizzo, @Value("${edificio3.citta}") String citta) {
        Postazione postazione = Postazione.builder()
                .nome(nome).indirizzo(indirizzo).citta(citta).id(UUID.randomUUID()).descrizione("Sala game LAN")
                .tipo(EnumPostazione.PRIVATO).maxPosti(5).build();
        return postazioneRepository.save(postazione);
    }

    @Bean("postazione4")
    public Postazione postazione4(@Value("${edificio2.nome}") String nome, @Value("${edificio2.indirizzo}") String indirizzo, @Value("${edificio2.citta}") String citta) {
        Postazione postazione = Postazione.builder()
                .nome(nome).indirizzo(indirizzo).citta(citta).id(UUID.randomUUID()).descrizione("Sala Conference a1")
                .tipo(EnumPostazione.SALA_RIUNIONI).maxPosti(35).build();
        return postazioneRepository.save(postazione);
    }

    @Bean("postazione5")
    public Postazione postazione5(@Value("${edificio3.nome}") String nome, @Value("${edificio3.indirizzo}") String indirizzo, @Value("${edificio1.citta}") String citta) {
        Postazione postazione = Postazione.builder()
                .nome(nome).indirizzo(indirizzo).citta(citta).id(UUID.randomUUID()).descrizione("Room Db1")
                .tipo(EnumPostazione.PRIVATO).maxPosti(10).build();
        return postazioneRepository.save(postazione);
    }

    //------------------------------CREAZIONE UTENTE--------------------------------
    @Bean("utente1")
    public Utente utente() {
        Utente utente = Utente.builder().nome(List.of(new String[]{"Mario", "Rossi"})).email("dfcs@cd.com").Username("MaRoss").build();
        utenteRepository.save(utente);
        return utente;
    }

    @Bean("utente2")
    public Utente utente2() {
        Utente utente = Utente.builder().nome(List.of(new String[]{"Giovanni", "Quarto"})).email("dfcs@cd.com").Username("Giovquarz").build();
        utenteRepository.save(utente);
        return utente;
    }

    @Bean("utente3")
    public Utente utente3() {
        Utente utente = Utente.builder().nome(List.of(new String[]{"Ugo", "Foscolo"})).email("dfcs@cd.com").Username("fosUg").build();
        utenteRepository.save(utente);
        return utente;
    }

    //------------------------------CREAZIONE PRENOTAZIONE--------------------------------
    @Bean("Prenotazione1")
    @DependsOn("postazione1")
    @Transactional
    public Prenotazione prenotazione1(@Qualifier("utente1") Utente utente, @Qualifier("postazione1") Postazione postazione) {

        Optional<Postazione> savedPostazione = postazioneRepository.findById(postazione.getId());
        if (!savedPostazione.isPresent())
            throw new RuntimeException("Postazione not saved correctly: " + postazione.getId());

        Prenotazione prenotazione = Prenotazione.builder()
                .data(LocalDate.of(2023, 5, 5)).postazione(postazione).utente(utente).build();
        prenotazioneRepository.save(prenotazione);
        return prenotazione;
    }

    @Bean("Prenotazione2")
    public Prenotazione prenotazione2(@Qualifier("utente2") Utente utente, @Qualifier("postazione2") Postazione postazione) {
        Prenotazione prenotazioneEsistente = prenotazioneRepository.findPrenotazioneByPostazioneAndData(postazione.getId(), LocalDate.of(2023, 8, 20));
        if (prenotazioneEsistente != null)
            throw new RuntimeException("La postazione è già stata assegnata per il giorno selezionato.");

        Prenotazione prenotazione = Prenotazione.builder()
                .data(LocalDate.of(2023, 8, 20)).postazione(postazione).utente(utente).build();
        prenotazioneRepository.save(prenotazione);
        return prenotazione;
    }

    @Bean("Prenotazione3")
    public Prenotazione prenotazione3(@Qualifier("utente3") Utente utente, @Qualifier("postazione3") Postazione postazione) {
        Prenotazione prenotazione = Prenotazione.builder()
                .data(LocalDate.of(2024, 2, 11)).postazione(postazione).utente(utente).build();
        prenotazioneRepository.save(prenotazione);
        return prenotazione;
    }

    @Bean("Prenotazione4")
    public Prenotazione prenotazione4(@Qualifier("utente2") Utente utente, @Qualifier("postazione4") Postazione postazione) {
        Prenotazione prenotazione = Prenotazione.builder()
                .data(LocalDate.of(2024, 8, 5)).postazione(postazione).utente(utente).build();
        prenotazioneRepository.save(prenotazione);
        return prenotazione;
    }

    @Bean("Prenotazione5")
    public Prenotazione prenotazione5(@Qualifier("utente1") Utente utente, @Qualifier("postazione5") Postazione postazione) {
        Prenotazione prenotazione = Prenotazione.builder()
                .data(LocalDate.of(2023, 9, 5)).postazione(postazione).utente(utente).build();
        prenotazioneRepository.save(prenotazione);
        return prenotazione;
    }

    @Bean("Prenotazione6")
    public Prenotazione prenotazione6(@Qualifier("utente3") Utente utente, @Qualifier("postazione1") Postazione postazione) {
        Prenotazione prenotazioneEsistente = prenotazioneRepository.findPrenotazioneByPostazioneAndData(postazione.getId(), LocalDate.of(2023, 5, 5));
        Prenotazione prenotazione = Prenotazione.builder()
                .data(LocalDate.of(2023, 5, 5)).postazione(postazione).utente(utente).build();
        if (prenotazioneEsistente != null)
            throw new RuntimeException("La postazione è già stata assegnata per il giorno selezionato.");
        else {
            prenotazioneRepository.save(prenotazione);
        }
        return prenotazione;
    }


}*/
