package epicode;

import epicode.dao.ClasseDao;
import epicode.dao.CorsoDao;
import epicode.dao.IndirizzoDao;
import epicode.dao.StudenteDao;
import epicode.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //emf è un oggetto che serve per creare un oggetto di tipo EntityManager che serve per interagire con il database tramite jpa hibernate
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode_Jpa");
        //createEntityManager() è un metodo di EntityManagerFactory che restituisce un oggetto di tipo EntityManager
        EntityManager em = emf.createEntityManager();
        //creazione di un oggetto di tipo StudenteDao, con il costruttore che prende come parametro un oggetto di tipo EntityManager
        StudenteDao studenteDao = new StudenteDao(em);
        IndirizzoDao indirizzoDao = new IndirizzoDao(em);
        ClasseDao classeDao = new ClasseDao(em);
        CorsoDao corsoDao = new CorsoDao(em);

//        Studente s1 = new Studente();
//        s1.setNome("Mario");
//        s1.setCognome("Rossi");
//        s1.setTipoStudente(TipoStudente.FULL_TIME);
//        s1.setDataNascita(java.time.LocalDate.of(1990, 1, 1));
//
//        Indirizzo indirizzo = new Indirizzo();
//        indirizzo.setVia("via roma 1");
//        indirizzo.setComune("Roma");
//        indirizzo.setProvincia("RM");
//        s1.setIndirizzo(indirizzo);
//        indirizzoDao.save(indirizzo);
//
//        studenteDao.save(s1);
//        em.refresh(indirizzo);
//        System.out.println(indirizzo.getStudente());
//        ClasseStudenti classe = new ClasseStudenti();
//        classe.setNome("4A");
//        classe.setPiano(2);
//       classeDao.save(classe);
//       Studente s2 = new Studente();
//        s2.setTipoStudente(TipoStudente.LAVORATORE);
//        s2.setNome("Paolo");
//        s2.setCognome("Verdi");
//        s2.setDataNascita(java.time.LocalDate.of(1995, 1, 1));
//        s2.setClasseStudenti(classe);
//        studenteDao.save(s2);
//        Studente s3 = studenteDao.getById(2);
//        ClasseStudenti classeStudenti2= classeDao.getById(3);
//        s3.setClasseStudenti(classeStudenti2);
//        studenteDao.save(s3);
//        ClasseStudenti classeStudenti = new ClasseStudenti();
//        classeStudenti.setNome("5A");
//        classeStudenti.setPiano(3);
//        classeDao.save(classeStudenti);
//        Studente s = studenteDao.getById(2);
//        s.setClasseStudenti(classeStudenti);
//        studenteDao.save(s);
//          ClasseStudenti classeStudenti = classeDao.getById(5);
//          classeStudenti.getStudenti().forEach(System.out::println);
        Corso c1 = new Corso();
        c1.setNome("Matematica");
        corsoDao.save(c1);
        Corso c2 = new Corso();
        c2.setNome("Italiano");
        corsoDao.save(c2);

        Studente s = studenteDao.getById(2);
        Studente s2 = studenteDao.getById(4);
        Studente s3 = studenteDao.getById(6);
        Studente s4 = studenteDao.getById(8);
        s.setCorsi(List.of(c1,c2));
        s2.setCorsi(List.of(c1,c2));
        s3.setCorsi(List.of(c1,c2));
        s4.setCorsi(List.of(c1,c2));
        studenteDao.save(s);
        studenteDao.save(s2);
        studenteDao.save(s3);
        studenteDao.save(s4);


    }
}
