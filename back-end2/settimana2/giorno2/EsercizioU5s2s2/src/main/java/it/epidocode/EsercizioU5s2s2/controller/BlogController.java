package it.epidocode.EsercizioU5s2s2.controller;

import it.epidocode.EsercizioU5s2s2.dto.BlogDto;
import it.epidocode.EsercizioU5s2s2.exeption.BlogeAutoreEccezione;
import it.epidocode.EsercizioU5s2s2.model.Autore;
import it.epidocode.EsercizioU5s2s2.model.Blog;
import it.epidocode.EsercizioU5s2s2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogPost")
public class BlogController {
    @Autowired
    private BlogService blogService;
    //aggiungo uno o piu blog
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveBlog(@RequestBody List<BlogDto> blogDto){
        blogDto.stream().forEach(blogService::saveBlog);
        return "Blog salvati con successo";
    }
    //restituisco le pagine del blog
    @GetMapping("")
    public Page<Blog> getAllBlogs(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "3")int size,
                                  @RequestParam(defaultValue = "id")String sortBy){
        return blogService.getAllBlogs(page, size, sortBy);
    }
    @GetMapping("/{id}")
    public Optional<Blog> getAutoregById(@PathVariable int id){
        return blogService.getAutoreById(id);
    }
    @PutMapping("/{id}")
    public String updateBlog(@PathVariable int id, @RequestBody BlogDto blogDto)throws BlogeAutoreEccezione{
        return  blogService.updateBlog(id,blogDto);
    }
    @DeleteMapping("/{id}")
    public String deleteBlog(@PathVariable int id)throws BlogeAutoreEccezione {
        return blogService.deleteBlog(id);
    }


 /*
    //elimino un blog in base all'id
    @DeleteMapping("/api/blogPost/{id}")
    public String deleteBlog(@PathVariable int id)throws BlogeAutoreEccezione {
        return blogService.deleteBlog(id);
    }
    @PutMapping("/api/blogPost/{id}")
    public String updateBlog(@PathVariable int id, @RequestBody Blog blog)throws BlogeAutoreEccezione{
        return  blogService.updateBlog(id,blog);
    }*/
}
