package it.epidocode.EsercizioU5s2s2.service;

import com.cloudinary.Cloudinary;
import it.epidocode.EsercizioU5s2s2.dto.BlogDto;
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
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private Cloudinary cloudinaryUploader;
    @Autowired
    private JavaMailSenderImpl javaMailSender;
    @Autowired AutoreRepository autoreRepository;
    public String saveBlog(BlogDto blogDto, MultipartFile cover) throws IOException {

        Blog blog=Blog.builder().categoria(blogDto.getCategoria())
                .titolo(blogDto.getTitolo()).cover((String) cloudinaryUploader.uploader().upload(cover.getBytes(), Collections.emptyMap()).get("url")).tempoDiLettura(blogDto.getTempoDiLettura())
                .contenuto(blogDto.getContenuto()).build();
        //cerco l'autore in base all'id passato nel dto e lo setto nel blog
        System.out.println(blogDto.getCover());
        Optional<Autore> autoreOptional=autoreRepository.findById(blogDto.getAutoreId());
        if (autoreOptional.isPresent()){
            blog.setAutore(autoreOptional.get());
            blogRepository.save(blog);
            return "Blog salvato con successo"+blog.getId();
        }else
            throw new BlogeAutoreEccezione("Autore con id="+blogDto.getAutoreId()+" non trovato");

    }
    //get restituisce tutti i blog
    public Page<Blog> getAllBlogs(int page,int size,String sortBy) {
        Pageable pageable= PageRequest.of(page,size, Sort.by(sortBy));
        return blogRepository.findAll(pageable);
    }
    public Optional<Blog> getAutoreById(int id){
        return blogRepository.findById(id);
    }
    public String updateBlog(int id, BlogDto blogDto) throws BlogeAutoreEccezione {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        if (blogOptional.isPresent()) {
            Optional<Autore> autoreOptional = autoreRepository.findById(blogDto.getAutoreId());
            if (!autoreOptional.isPresent()) {
                throw new BlogeAutoreEccezione("Autore con ID " + blogDto.getAutoreId() + " non trovato.");
            }
            Blog updatedBlog = Blog.builder()
                    .categoria(blogDto.getCategoria())
                    .titolo(blogDto.getTitolo())
                    .cover(blogDto.getCover())
                    .tempoDiLettura(blogDto.getTempoDiLettura())
                    .contenuto(blogDto.getContenuto())
                    .autore(autoreOptional.get())
                    .build();
            updatedBlog.setId(id);
            blogRepository.save(updatedBlog);
            return "Blog aggiornato con successo con ID: " + id;
        } else {
            throw new BlogeAutoreEccezione("Blog con ID " + id + " non trovato.");
        }
    }
    public String deleteBlog(int id){
        Optional<Blog> blogOptional = blogRepository.findById(id);
        if (!blogOptional.isPresent()) {
            throw new BlogeAutoreEccezione("Blog con ID " + id + " non trovato.");
        }else {
            blogRepository.deleteById(id);
            return "Blog rimosso con successo";
            }
    }

   /*
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
    }*/

}
