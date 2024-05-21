package it.epidocode.EsercizioU5s2s2.service;

import it.epidocode.EsercizioU5s2s2.exeption.BlogeAutoreEccezione;
import it.epidocode.EsercizioU5s2s2.model.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BlogService {
    private List<Blog> blogs=new ArrayList<>();
//salva un blog
    public String saveBlog(Blog blog){
        blogs.add(blog);
        return "Blog salvato con successo"+blog.getId();
    }
    //get restituisce tutti i blog
    public List<Blog> getAllBlogs() {
        return blogs;
    }
    //get restituisce un blog in base all'id
    public Blog getBlogById(int id){
        return blogs.stream().filter(b->b.getId()==id).findFirst().get();
    }
    //delete elimina un blog in base all'id
    public String deleteBlog(int id){
        blogs.removeIf(b->b.getId()==id);
        return "Blog rimosso con successo";
    }
    public String updateBlog(int id, Blog blog) throws BlogeAutoreEccezione {
        boolean[] updated = {false};  // Workaround to throw an exception inside the lambda

        blogs.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .ifPresentOrElse(bx -> {
                    bx.setCategoria(blog.getCategoria());
                    bx.setTitolo(blog.getTitolo());
                    bx.setCover(blog.getCover());
                    bx.setContenuto(blog.getContenuto());
                    bx.setTempoDiLettura(blog.getTempoDiLettura());
                    updated[0] = true;
                }, () -> {
                    updated[0] = false;
                });

        if (!updated[0]) {
            throw new BlogeAutoreEccezione("Blog con ID " + id + " non trovato.");
        }

        return "Blog aggiornato con successo con ID: " + id;
    }

}
