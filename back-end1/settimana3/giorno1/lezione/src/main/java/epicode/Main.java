package epicode;

import epicode.dao.StudenteDao;
import epicode.entity.Studente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main
{
    public static void main(String[] args)
    {
        //emf è un oggetto che serve per creare un oggetto di tipo EntityManager che serve per interagire con il database tramite jpa hibernate
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode_Jpa");
        //createEntityManager() è un metodo di EntityManagerFactory che restituisce un oggetto di tipo EntityManager
        EntityManager em= emf.createEntityManager();
        //creazione di un oggetto di tipo StudenteDao, con il costruttore che prende come parametro un oggetto di tipo EntityManager
        StudenteDao studenteDao=new StudenteDao(em);

        Studente s1=new Studente();
        s1.setNome("Mario");
        s1.setCognome("Rossi");
        s1.setIndirizzo("via roma 1");
        s1.setDataNascita(java.time.LocalDate.of(1990, 1, 1));
       // System.out.println(s1);
      //  studenteDao.save(s1);
        Studente s2=studenteDao.getById(2);
        System.out.println(s2);
       // s2.setIndirizzo("via milano 2");
       // studenteDao.save(s2);
        studenteDao.delete(s2);
    }
}
