package it.epicode.u5S2G4.repository;

import it.epicode.u5S2G4.bean.Dispositivo;
import it.epicode.u5S2G4.bean.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudenteRepository extends JpaRepository<Studente, Integer> {
   /* public List<Studente> findeByNome(String nome);
    public List<Dispositivo> findByNomeLike(String nome);*/
}
