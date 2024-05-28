package it.dispositiviAziendali.pgM5S2G5.repository;

import it.dispositiviAziendali.pgM5S2G5.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DispositivoRepository extends JpaRepository<Dispositivo, UUID> {
}
