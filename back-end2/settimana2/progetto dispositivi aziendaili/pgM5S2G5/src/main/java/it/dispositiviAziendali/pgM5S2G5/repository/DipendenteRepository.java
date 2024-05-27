package it.dispositiviAziendali.pgM5S2G5.repository;

import it.dispositiviAziendali.pgM5S2G5.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DipendenteRepository extends JpaRepository<Dipendente, Integer>{
}
