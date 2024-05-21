package it.epidocode.EsercizioU5s2s2.service;

import it.epidocode.EsercizioU5s2s2.exeption.BlogeAutoreEccezione;
import it.epidocode.EsercizioU5s2s2.model.Autore;
import it.epidocode.EsercizioU5s2s2.model.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoreService {
    private List<Autore>autori=new ArrayList<>();

    //salva un blog
    public String saveAutore(Autore blog){
        autori.add(blog);
        return "Autore salvato con successo"+blog.getId();
    }
    //get restituisce tutti i blog
    public List<Autore> getAllAutores() {
        return autori;
    }
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
    }

}
