package it.epidocode.EsercizioU5s2s2.service;

import it.epidocode.EsercizioU5s2s2.exeption.BlogeAutoreEccezione;
import it.epidocode.EsercizioU5s2s2.model.Autore;
import it.epidocode.EsercizioU5s2s2.model.Blog;
import it.epidocode.EsercizioU5s2s2.repository.AutoreRepository;
import it.epidocode.EsercizioU5s2s2.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutoreService {
    @Autowired
    AutoreRepository autoreRepository;
    @Autowired
    BlogRepository blogRepository;
    public String saveAutore(Autore autore){
        autoreRepository.save(autore);
        return "Autore salvato con successo"+autore.getId();
    }
    public Page<Autore> getAllBlogs(int page, int size, String sortBy) {
        Pageable pageable= PageRequest.of(page,size, Sort.by(sortBy));
        return autoreRepository.findAll(pageable);
    }
    //get restituisce un blog in base all'id
    public Optional<Autore> getAutoreById(int id){
        return autoreRepository.findById(id);
    }
    public String updateAutore(int id, Autore autore) throws BlogeAutoreEccezione {
        Optional<Autore> autoreOptional = autoreRepository.findById(id);
        if (autoreOptional.isPresent()) {
            Autore updatedAutore = Autore.builder()
                    .nome(autore.getNome())
                    .cognome(autore.getCognome())
                    .email(autore.getEmail())
                    .dataDiNascita(autore.getDataDiNascita())
                    .avatar(autore.getAvatar())
                    .build();
            updatedAutore.setId(id);
            updatedAutore.initAvatar();
            autoreRepository.save(updatedAutore);
            return "Autore aggiornato con successo con ID: " + id;
        } else {
            throw new BlogeAutoreEccezione("Autore con ID " + id + " non trovato.");
        }
    }
    public String deleteAutore(int id){
        Optional<Autore> autoreOptional = autoreRepository.findById(id);
        if (!autoreOptional.isPresent()) {
            throw new BlogeAutoreEccezione("Autore con ID " + id + " non trovato.");
        }
        else {
            Autore autore = autoreOptional.get();
            autore.getBlog().forEach(blog -> blogRepository.delete(blog));
            // Delete the author
            autoreRepository.delete(autore);

        }
        return "Autore rimosso con successo";
    }


    /*private List<Autore>autori=new ArrayList<>();

    //get restituisce un blog in base all'id
    public Autore getAutoreById(int id){
        return autori.stream().filter(b->b.getId()==id).findFirst().get();
    }
    public String updateAutore(int id, Autore autore) throws BlogeAutoreEccezione {
        boolean[] updated = {false};  // Workaround to throw an exception inside the lambda

        autori.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .ifPresentOrElse(bx -> {
                    bx.setNome(autore.getNome());
                    bx.setCognome(autore.getCognome());
                    bx.setEmail(autore.getEmail());
                    bx.setDataDiNascita(autore.getDataDiNascita());

                    String firstName = autore.getNome().split("\\s+")[0];
                    String lastName = autore.getCognome().split("\\s+")[0];
                    System.out.println(autore.getAvatar());
                    bx.setAvatar("https://ui-avatars.com/api/?name=" + firstName + "+" + lastName);
                    System.out.println(autore.getAvatar());
                    updated[0] = true;
                }, () -> {
                    updated[0] = false;
                });

        if (!updated[0]) {
            throw new BlogeAutoreEccezione("Autore con ID " + id + " non trovato.");
        }

        return "Autore aggiornato con successo con ID: " + id;
    }
    public String deleteAutore(int id){
        autori.removeIf(b->b.getId()==id);
        return "Autore rimosso con successo";
    }*/

}
