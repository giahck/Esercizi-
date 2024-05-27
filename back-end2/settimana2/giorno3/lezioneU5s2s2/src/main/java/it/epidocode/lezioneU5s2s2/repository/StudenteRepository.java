package it.epidocode.lezioneU5s2s2.repository;

import it.epidocode.lezioneU5s2s2.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenteRepository extends JpaRepository<Studente,Integer> {
}
