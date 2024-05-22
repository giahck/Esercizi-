package it.epidocode.lezioneU5s2s2.service;

import it.epidocode.lezioneU5s2s2.Dto.AulaDto;
import it.epidocode.lezioneU5s2s2.exeption.StudenteNonTrovatoException;
import it.epidocode.lezioneU5s2s2.model.Aula;
import it.epidocode.lezioneU5s2s2.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaService {
    @Autowired
    private AulaRepository aulaRepository;

    public String saveAula(AulaDto aulaDto) {
        Aula aula = new Aula();
        aula.setNome(aulaDto.getNome());
        aula.setPiano(aulaDto.getPiano());

        aulaRepository.save(aula);
        return "Aula con id=" + aula.getId() + " creata con successo";
    }

    public List<Aula> getAule(){
        return  aulaRepository.findAll();
    }

    public Optional<Aula> getAulaById(int id){
        return  aulaRepository.findById(id);
    }
    public Aula updateAula(int id,AulaDto auladto)throws StudenteNonTrovatoException{
        Optional<Aula>aulaOptional=getAulaById(id);
        if (aulaOptional.isPresent()){
            Aula aula=aulaOptional.get();
            aula.setNome(auladto.getNome());
            aula.setPiano(aula.getPiano());

            return aulaRepository.save(aula);
        }else
            throw new StudenteNonTrovatoException("Aula con id="+id+" non trovata");
    }
    public  String deleteAula(int id)throws StudenteNonTrovatoException{
        Optional<Aula> aulaOptional=getAulaById(id);
        if (aulaOptional.isPresent()){
            aulaRepository.delete(aulaOptional.get());
            return "Aula con id="+id+" cancellata con sucesso";
        }else
            throw new StudenteNonTrovatoException("Aula con id="+id+" non trovata");

    }

}
