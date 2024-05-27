package it.epidocode.EsercizioU5s2s2.controller;

import it.epidocode.EsercizioU5s2s2.dto.BlogDto;
import it.epidocode.EsercizioU5s2s2.exeption.BlogeAutoreEccezione;
import it.epidocode.EsercizioU5s2s2.model.Autore;
import it.epidocode.EsercizioU5s2s2.model.Blog;
import it.epidocode.EsercizioU5s2s2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public String saveBlog(@RequestPart("cover") MultipartFile cover, @RequestBody @Validated List<BlogDto> blogDto, BindingResult bindingResult) {
           if (bindingResult.hasErrors()){
            throw new BlogeAutoreEccezione("Richiesta non valida: "+bindingResult.getAllErrors().stream().map(e->e.getDefaultMessage()).reduce("",(s1,s2)->s1+"\n"+s2));
        }
        blogDto.stream().forEach(blog -> {
            try {
                blogService.saveBlog(blog, cover);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
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
    public String updateBlog(@PathVariable int id, @RequestBody @Validated BlogDto blogDto,BindingResult bindingResult)throws BlogeAutoreEccezione{
       if (bindingResult.hasErrors()){
            throw new BlogeAutoreEccezione("Richiesta non valida: "+bindingResult.getAllErrors().stream().map(e->e.getDefaultMessage()).reduce("",(s1,s2)->s1+"\n"+s2));
        }
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
