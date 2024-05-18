package it.proggettoS1M5.GestionePrenotzioni.Repository;

import it.proggettoS1M5.GestionePrenotzioni.Enum.EnumPostazione;
import it.proggettoS1M5.GestionePrenotzioni.bean.Postazione;
import jakarta.persistence.Enumerated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {
    @Query("SELECT p FROM Postazione p WHERE p.citta = :citta AND p.tipo = :tipo")
    List<Postazione> findPostazioniByCittaAndTipo(@Param("citta") String citta, @Param("tipo") EnumPostazione tipo);
}
