package it.epidocode.lezioneU5s2s2.service;

import it.epidocode.lezioneU5s2s2.Dto.StudenteDto;
import it.epidocode.lezioneU5s2s2.exeption.StudenteNonTrovatoException;
import it.epidocode.lezioneU5s2s2.model.Aula;
import it.epidocode.lezioneU5s2s2.model.Studente;
import it.epidocode.lezioneU5s2s2.repository.AulaRepository;
import it.epidocode.lezioneU5s2s2.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudenteService {
    @Autowired
    private StudenteRepository studenteRepository;

    @Autowired
    private AulaRepository aulaRepository;
    public String saveStudente(StudenteDto studenteDto)throws StudenteNonTrovatoException{
        Studente studente=new Studente();
        studente.setNome(studenteDto.getNome());
        studente.setCognome(studenteDto.getCognome());
        studente.setDataNascita(studenteDto.getDataNascita());

        Optional<Aula>aulaOptional=aulaRepository.findById(studenteDto.getAulaId());
        if (aulaOptional.isPresent()) {
            Aula aula=aulaOptional.get();
            studente.setAula(aula);
            studenteRepository.save(studente);
            return "Studente con matricola "+studente.getMatricola()+" salvato corretamente";
        }else
            throw new StudenteNonTrovatoException("Aula con id="+studenteDto.getAulaId()+" non trovata");

    }
    public Page<Studente> getStudente(int page,int size,String sortBy){
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return studenteRepository.findAll(pageable);
    }
    public Optional<Studente>getStudenteById(int matricola){
        return studenteRepository.findById(matricola);
    }
    public Studente updateStudente(int matricola,StudenteDto studenteDto)throws StudenteNonTrovatoException{
         Optional<Studente> studenteOptional=getStudenteById(matricola);

        if (studenteOptional.isPresent()){
            Studente studente=studenteOptional.get();
            studente.setNome(studenteDto.getNome());
            studente.setCognome(studenteDto.getCognome());
            studente.setDataNascita(studenteDto.getDataNascita());
            Optional<Aula>aulaOptional=aulaRepository.findById(studenteDto.getAulaId());
            if (aulaOptional.isPresent()) {
                Aula aula=aulaOptional.get();
                studente.setAula(aula);
                studenteRepository.save(studente);
                return studente;
            }else
                throw new StudenteNonTrovatoException("Aula con id="+studenteDto.getAulaId()+" non trovata");
        }
        else throw new StudenteNonTrovatoException("Studente con matricola="+matricola+" non trovato");
    }
    public String deleteStudente(int matricola)throws StudenteNonTrovatoException{
        Optional<Studente>optionalStudente= studenteRepository.findById(matricola);
        if (optionalStudente.isPresent()){
            studenteRepository.delete(optionalStudente.get());
            return "Studente con matricola="+matricola+" cancellato con successo";
        }
            else throw new StudenteNonTrovatoException("Studente con matricola="+matricola+" non trovato");

    }
}
