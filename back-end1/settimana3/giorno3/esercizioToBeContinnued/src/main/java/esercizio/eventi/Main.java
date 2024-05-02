package esercizio.eventi;

import esercizio.eventi.dao.EventiDao;
import esercizio.eventi.dao.LocationDeo;
import esercizio.eventi.dao.PartecipazioneDeo;
import esercizio.eventi.dao.PersonaDeo;
import esercizio.eventi.entity.*;

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
        EventiDao eventiDao=new EventiDao(em);
        LocationDeo locationDeo=new LocationDeo(em);
        PartecipazioneDeo partecipazioneDeo=new PartecipazioneDeo(em);
        PersonaDeo personaDeo=new PersonaDeo(em);
//        Eventi e1=new Eventi();
//        e1.setTitolo("Imaggine dragons live Vegas");
//        e1.setDataEvento(java.time.LocalDate.of(2024, 07, 25));
//        e1.setDescrizione("Concerto degli Imagine Dragons a Las Vegas");
//        e1.setTipoEvento(tipoEvento.CONCERTO);
//        e1.setNumeroPartecipanti(90000);
//        eventiDao.save(e1);
//        Eventi ev1=eventiDao.getById(1);
//        System.out.println(ev1);
//        eventiDao.delete(ev1);
//        List<Eventi> eventiList= eventiDao.query();
//        eventiList.stream().filter(e->e.getId()==3).findFirst().ifPresent(e->e.setDescrizione("Festa di compleanno di Mario aggiornata"));
//        eventiDao.update(eventiList.get(1));
       /* Location l1=new Location();
        l1.setNome("Piazza del Popolo");
        l1.setCitta("Roma");
        locationDeo.save(l1);
        Location l2=new Location("Piazza Maggiore", "Bologna");
        locationDeo.save(l2);*/
        /*Eventi e1=new Eventi();
        e1.setTitolo("Festa di compleanno di Mario");
        e1.setDataEvento(java.time.LocalDate.of(2024, 07, 25));
        e1.setDescrizione("Festa di compleanno di Mario");
        e1.setTipoEvento(tipoEvento.PRIVATO);
        e1.setNumeroPartecipanti(50);

        Location l1=new Location();
        l1.setNome("via amedeo");
        l1.setCitta("Teramo");
        locationDeo.save(l1);
        e1.setLocation(l1);
        eventiDao.save(e1);*/
       /* Persone p1=new Persone();
        p1.setNome("Mario");
        p1.setCognome("Rossi");
        p1.setEmail("Mario@gmail.com");
        p1.setData_di_nascita(java.time.LocalDate.of(1990, 1, 1));
        p1.setSesso('M');
        Partecipazioni partecipazioni=new Partecipazioni();
        partecipazioni.setEventi(eventiDao.getById(1));
        partecipazioni.setPersone(p1);
        partecipazioneDeo.save(partecipazioni);
        System.out.println(partecipazioni.toString());*/
        Eventi e1=new Eventi();
        e1.setTitolo("raduno moto");
        e1.setDataEvento(java.time.LocalDate.of(2024, 07, 25));
        e1.setDescrizione("raduno moto a teramo");
        e1.setTipoEvento(tipoEvento.PRIVATO);
        e1.setNumeroPartecipanti(50);
        eventiDao.save(e1);
        Location l1=new Location();
        l1.setNome("via amedeo");
        l1.setCitta("Teramo");
        locationDeo.save(l1);
        e1.setLocation(l1);

        Persone p1=new Persone();
        p1.setNome("Giovanni");
        p1.setCognome("Battiato");
        p1.setEmail("sdvs@sdv.com");
        p1.setSesso('M');
        personaDeo.save(p1);
        Persone p2=new Persone();
        p2.setNome("Rina");
        p2.setCognome("bastiato");
        p2.setEmail("sdf@sdv.com");
        p2.setSesso('F');
        personaDeo.save(p2);
        Partecipazioni partecipazioni=new Partecipazioni();
        partecipazioni.setEventi(e1);
        partecipazioni.setPersone(p1);
        partecipazioneDeo.save(partecipazioni);
        Partecipazioni partecipazioni2=new Partecipazioni();
        partecipazioni2.setEventi(e1);
        partecipazioni2.setPersone(p2);
        partecipazioneDeo.save(partecipazioni2);




    }
}
