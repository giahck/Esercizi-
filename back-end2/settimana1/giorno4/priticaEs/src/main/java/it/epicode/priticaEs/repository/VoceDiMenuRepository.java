package it.epicode.priticaEs.repository;

import it.epicode.priticaEs.bean.Pizza;
import it.epicode.priticaEs.bean.VoceDiMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoceDiMenuRepository extends JpaRepository<VoceDiMenu, Integer> {
    public List<Pizza> findByPrezzoLessThan(double prezzo);

    @Query("SELECT COUNT(p) FROM Pizza p")
    public long countPizze();

}
