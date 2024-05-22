package it.epidocode.EsercizioU5s2s2.repository;

import it.epidocode.EsercizioU5s2s2.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
}
