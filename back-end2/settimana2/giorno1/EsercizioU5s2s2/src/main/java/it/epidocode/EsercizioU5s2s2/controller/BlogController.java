package it.epidocode.EsercizioU5s2s2.controller;

import it.epidocode.EsercizioU5s2s2.exeption.BlogeAutoreEccezione;
import it.epidocode.EsercizioU5s2s2.model.Blog;
import it.epidocode.EsercizioU5s2s2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;
    //aggiungo uno o piu blog
    @PostMapping("/api/blogPost")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveBlog(@RequestBody List<Blog> blog){
        blog.stream().forEach(blogService::saveBlog);
        return "Blog salvati con successo";
    }
    //restituisco tutti i blog
    @GetMapping("/api/blogPost")
    public List<Blog> getAllBlogs(){
        return blogService.getAllBlogs();
    }
    //restituisco un blog in base all'id
    @GetMapping("/api/blogPost/{id}")
    public Blog getBlogById(@PathVariable int id){
        return blogService.getBlogById(id);
    }
    //elimino un blog in base all'id
    @DeleteMapping("/api/blogPost/{id}")
    public String deleteBlog(@PathVariable int id)throws BlogeAutoreEccezione {
        return blogService.deleteBlog(id);
    }
    @PutMapping("/api/blogPost/{id}")
    public String updateBlog(@PathVariable int id, @RequestBody Blog blog)throws BlogeAutoreEccezione{
        return  blogService.updateBlog(id,blog);
    }
}
