package it.epidocode.EsercizioU5s2s2.controller;

import it.epidocode.EsercizioU5s2s2.exeption.BlogeAutoreEccezione;
import it.epidocode.EsercizioU5s2s2.model.Autore;
import it.epidocode.EsercizioU5s2s2.model.Blog;
import it.epidocode.EsercizioU5s2s2.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @PostMapping("/api/authors")
    public String saveBlog(@RequestBody List<Autore> autore){
        autore.stream().forEach(autoreService::saveAutore);
        return "Autore salvati con successo";
    }
    @GetMapping("/api/authors")
    public List<Autore>getAllautore(){
        return  autoreService.getAllAutores();
    }
    @GetMapping("/api/authors/{id}")
    public Autore getAutoregById(@PathVariable int id){
        return autoreService.getAutoreById(id);
    }
    @PutMapping("/api/authors/{id}")
    public String updateBlog(@PathVariable int id, @RequestBody Autore autore)throws BlogeAutoreEccezione {
        return  autoreService.updateAutore(id,autore);
    }
    @DeleteMapping("/api/authors/{id}")
    public String deleteAutori(@PathVariable int id)throws BlogeAutoreEccezione {
        return autoreService.deleteAutore(id);
    }
}
