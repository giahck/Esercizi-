package it.proggettoS1M5.GestionePrenotzioni.Repository;

import it.proggettoS1M5.GestionePrenotzioni.bean.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.UUID;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer>{
    @Query("SELECT p FROM Prenotazione p WHERE p.postazione.id = :postazioneId AND p.data = :data")
    Prenotazione findPrenotazioneByPostazioneAndData(@Param("postazioneId") UUID postazioneId, @Param("data") LocalDate data);
    @Query("SELECT count(p) FROM Prenotazione p WHERE p.utente.username = :username")
    long countPrenotazioniByUsername(@Param("username") String username);
}
