package it.epidocode.lezioneU5s2s2.controller;

import it.epidocode.lezioneU5s2s2.Dto.AulaDto;
import it.epidocode.lezioneU5s2s2.exeption.StudenteNonTrovatoException;
import it.epidocode.lezioneU5s2s2.model.Aula;
import it.epidocode.lezioneU5s2s2.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api")
public class AulaController {
    @Autowired
    private AulaService aulaService;

    @PostMapping("/api/aule")
    public  String saveAula(@RequestBody AulaDto aulaDto){
        return aulaService.saveAula(aulaDto);
    }

    @GetMapping("/api/aule")
    public List<Aula> getAule(){
        return aulaService.getAule();
    }
    @GetMapping("/api/aule/{id}")
    public Aula getAulaById(@PathVariable int id) throws StudenteNonTrovatoException {
       Optional<Aula>aulaOptional= aulaService.getAulaById(id);
        if (aulaOptional.isPresent()){
            return aulaOptional.get();
        }else
            throw new StudenteNonTrovatoException("Aula con id="+id+" non trovata");
    }
    @PutMapping("/api/aule/{id}")
    public Aula updateAula(@PathVariable int id, @RequestBody AulaDto aulaDto) throws StudenteNonTrovatoException {
        return  aulaService.updateAula(id,aulaDto);
    }

    /*public  String deleteAula()*/
}
