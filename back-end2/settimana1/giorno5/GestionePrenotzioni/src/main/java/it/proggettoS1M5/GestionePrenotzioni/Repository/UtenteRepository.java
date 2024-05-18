package it.proggettoS1M5.GestionePrenotzioni.Repository;

import it.proggettoS1M5.GestionePrenotzioni.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UtenteRepository extends JpaRepository<Utente, UUID>{
}
