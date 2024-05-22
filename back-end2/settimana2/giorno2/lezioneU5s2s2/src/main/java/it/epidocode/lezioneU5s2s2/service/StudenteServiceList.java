package it.epidocode.lezioneU5s2s2.service;

import it.epidocode.lezioneU5s2s2.exeption.StudenteNonTrovatoException;
import it.epidocode.lezioneU5s2s2.model.Studente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudenteServiceList {
    private List<Studente> studenti = new ArrayList<>();

    public Optional<Studente> getStudenteByMatricola(int matricola) {
        return studenti.stream().filter(s -> s.getMatricola() == matricola).findFirst();
    }

    public List<Studente> getStudenti() {
        return studenti;
    }

    public String saveStudente(Studente studente) {
        studenti.add(studente);
        return "Studente salvato" + studente.getMatricola();
    }

    public Studente updateStudente(int matricola, Studente studenteUpd)throws StudenteNonTrovatoException {
        Optional<Studente> studenteOpt = getStudenteByMatricola(matricola);
        if (studenteOpt.isPresent()) {
            Studente studente = studenteOpt.get();
            studente.setNome(studenteUpd.getNome());
            studente.setCognome(studenteUpd.getCognome());
            studente.setDataNascita(studenteUpd.getDataNascita());
            return studente;
        }
        else
            throw  new StudenteNonTrovatoException("Studente non trovato");
    }
    public String deleteStudente(int matricola)throws StudenteNonTrovatoException{
        Optional<Studente> studenteOpt = getStudenteByMatricola(matricola);
        if (studenteOpt.isPresent()){
            studenti.remove(studenteOpt.get());
            return "Studente rimosso";
        }
        else
            throw  new StudenteNonTrovatoException("Studente non trovato");
    }
}
