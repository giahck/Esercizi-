package it.epicode.u5S2G4.repository;

import it.epicode.u5S2G4.bean.Computer;
import it.epicode.u5S2G4.bean.Dispositivo;
import it.epicode.u5S2G4.bean.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DispositivoRepository extends JpaRepository<Dispositivo,Integer> {
    /*public List<Studente> findeByNome(String nome);
    public List<Dispositivo> findByNomeLike(String nome);*/
   // List<Dispositivo> findAllByOrderByNomeAsc();
    public  List<Computer>findByRamLessThan(int ram);
}
