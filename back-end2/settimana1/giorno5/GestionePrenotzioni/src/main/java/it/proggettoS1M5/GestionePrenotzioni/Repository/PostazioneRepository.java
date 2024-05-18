package it.proggettoS1M5.GestionePrenotzioni.Repository;

import it.proggettoS1M5.GestionePrenotzioni.bean.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {

}
