package esercizio.eventi;

import esercizio.eventi.dao.EventiDao;
import esercizio.eventi.entity.Eventi;
import esercizio.eventi.entity.tipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("ese_gdue_mquattro");
        EntityManager em=emf.createEntityManager();

        Eventi e1=new Eventi();
        e1.setTitolo("Festa di compleanno");
        e1.setDataEvento(java.time.LocalDate.of(2021, 10, 10));
        e1.setDescrizione("Festa di compleanno di Mario");
        e1.setTipoEvento(tipoEvento.FESTA);
        e1.setNumeroPartecipanti(10);
        EventiDao eventiDao=new EventiDao(em);
        eventiDao.save(e1);
//        Eventi ev1=eventiDao.getById(1);
//        System.out.println(ev1);
//        eventiDao.delete(ev1);
//        List<Eventi> eventiList= eventiDao.query();
//        eventiList.stream().filter(e->e.getId()==3).findFirst().ifPresent(e->e.setDescrizione("Festa di compleanno di Mario aggiornata"));
//        eventiDao.update(eventiList.get(1));



    }
}
