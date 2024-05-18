package it.epicode.priticaEs.service;

import it.epicode.priticaEs.bean.Pizza;
import it.epicode.priticaEs.bean.VoceDiMenu;
import it.epicode.priticaEs.repository.VoceDiMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoceDiMenuService {
    @Autowired
    private VoceDiMenuRepository voceDiMenuRepository;

    public VoceDiMenu salvaVoceDiMenu(VoceDiMenu voceDiMenu){
        return voceDiMenuRepository.save(voceDiMenu);
    }

    public List<Pizza> getPizzePriceLessThan(double prezzo){
        return voceDiMenuRepository.findByPrezzoLessThan(prezzo);
    }

    public long countPizze(){
        return voceDiMenuRepository.countPizze();
    }
}
