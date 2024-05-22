package it.epidocode.EsercizioU5s2s2.controller;

import it.epidocode.EsercizioU5s2s2.exeption.BlogeAutoreEccezione;
import it.epidocode.EsercizioU5s2s2.model.Autore;
import it.epidocode.EsercizioU5s2s2.model.Blog;
import it.epidocode.EsercizioU5s2s2.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @PostMapping("")
    public String saveBlog(@RequestBody List<Autore> autore){
        autore.stream().forEach(a -> {
            a.initAvatar();
            autoreService.saveAutore(a);
        });
        return "Autore salvati con successo";
    }
    @GetMapping("")
    public Page<Autore> getAllBlogs(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10")int size,
                                  @RequestParam(defaultValue = "id")String sortBy){
        return autoreService.getAllBlogs(page, size, sortBy);
    }


    @GetMapping("/{id}")
    public Optional<Autore> getAutoregById(@PathVariable int id){
        return autoreService.getAutoreById(id);
    }
    @PutMapping("/{id}")
    public String updateAutore(@PathVariable int id, @RequestBody Autore autore){
        return  autoreService.updateAutore(id,autore);
    }
    @DeleteMapping("/{id}")
    public String deleteAutori(@PathVariable int id) {
        return autoreService.deleteAutore(id);
    }

  /*  @PutMapping("/api/authors/{id}")
    public String updateBlog(@PathVariable int id, @RequestBody Autore autore)throws BlogeAutoreEccezione {
        return  autoreService.updateAutore(id,autore);
    }
    @DeleteMapping("/api/authors/{id}")
    public String deleteAutori(@PathVariable int id)throws BlogeAutoreEccezione {
        return autoreService.deleteAutore(id);
    }*/
}
