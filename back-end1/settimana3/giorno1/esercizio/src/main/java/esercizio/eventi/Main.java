package esercizio.eventi;

import esercizio.eventi.dao.EventiDao;
import esercizio.eventi.entity.Eventi;
import esercizio.eventi.entity.tipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("ese_gdue_mquattro");
        EntityManager em=emf.createEntityManager();

        EventiDao eventiDao=new EventiDao(em);
        Eventi e1=new Eventi();
        e1.setTitolo("Festa di compleanno");
        e1.setDataEvento(java.time.LocalDate.of(2021, 10, 10));
        e1.setDescrizione("Festa di compleanno di Mario");
        e1.setTipoEvento(tipoEvento.FESTA);
        e1.setNumeroPartecipanti(10);
        eventiDao.save(e1);
//        Eventi ev1=eventiDao.getById(1);
//        System.out.println(ev1);
//        eventiDao.delete(ev1);


    }
}
