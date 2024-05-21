package it.epidocode.lezioneU5s2s2.controller;

import it.epidocode.lezioneU5s2s2.exeption.StudenteNonTrovatoException;
import it.epidocode.lezioneU5s2s2.model.Studente;
import it.epidocode.lezioneU5s2s2.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudenteController {
  /*  @GetMapping("/api")
    private String benvenuto() {
        return "<h1><center>Benvenuto nella pagina di gestione studenti</center></h1>";
    }

    @GetMapping("/api/nome_cognome")
    public String bevenuto2(@RequestParam String nome, String cognome) {
        return "bnvenuto " + nome + " " + cognome;
    }

    @GetMapping("/api/{n}/{cognome}")
    public String benvenuto3(@PathVariable(name = "n") String nome, @PathVariable String cognome) {
        return "Benvenuto a sti due " + nome + " " + cognome;
    }
    @GetMapping("/api/inBody")
    public String benvenuto4(@RequestBody String nomeCognome) {
        return "Benvenuto a sti due "+nomeCognome;
    }*/
    @Autowired
    private StudenteService studenteService;

    @PostMapping("/api/studenti")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveStudenti(@RequestBody List<Studente> studenti) {
        for (Studente studente : studenti) {
            studenteService.saveStudente(studente);
        }
        return "Studenti salvati con successo";
    }

    @GetMapping("/api/studenti")
    public List<Studente> getAllStudenti(){
        return studenteService.getStudenti();
    }
    @GetMapping("/api/studenti/{matricola}")
    public Studente getStudenteByMatricola(@PathVariable int matricola)throws StudenteNonTrovatoException{
       Optional<Studente>studenteOpt= studenteService.getStudenteByMatricola(matricola);
         if(studenteOpt.isPresent())
              return studenteOpt.get();
         else
              throw new StudenteNonTrovatoException( "Studente non trovato "+matricola);
    }

    @PutMapping("/api/studenti/{matricola}")
    @ResponseStatus(HttpStatus.OK)//200 di default
    public Studente updateStudente(@PathVariable int matricola, @RequestBody Studente studenteUpd)throws StudenteNonTrovatoException {
        return studenteService.updateStudente(matricola, studenteUpd);
    }
    @DeleteMapping("/api/studenti/{matricola}")
    public String deleteStudente(@PathVariable int matricola)throws StudenteNonTrovatoException{
        return studenteService.deleteStudente(matricola);
    }

}
