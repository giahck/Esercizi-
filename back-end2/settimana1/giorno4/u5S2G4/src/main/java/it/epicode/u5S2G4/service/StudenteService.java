package it.epicode.u5S2G4.service;

import it.epicode.u5S2G4.bean.Studente;
import it.epicode.u5S2G4.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudenteService {
    @Autowired
    private StudenteRepository studenteRepository;

    public void inserisciStudente(Studente studente) {
       studenteRepository.save(studente);
    }
    public Studente getStudente(int matricola) {
       return studenteRepository.findById(matricola).get();
    }
    public List<Studente> getStudenti() {
       return studenteRepository.findAll();
    }
    public void eliminaStudente(int matricola) {
       studenteRepository.deleteById(matricola);
    }
    /*public List<Studente> findStudentiByNome(String nome) {
        return studenteRepository.findByNome(nome);
    }*/
}
