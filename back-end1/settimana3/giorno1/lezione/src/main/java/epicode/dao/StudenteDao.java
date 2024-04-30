package epicode.dao;

import epicode.entity.Studente;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class StudenteDao {

    private EntityManager em;

    public StudenteDao(EntityManager em) {
        this.em = em;
    }
    public void  save(Studente studente){
        EntityTransaction et=em.getTransaction();//inizializzazione della transazione
        et.begin();//inizio della transazione
        em.persist(studente);//salvataggio dello studente
        et.commit();//fine della transazione
    }
    public Studente getById(int matricola){
        //inizializzazione della transazione per l'aggiornamento dello studente con matricola uguale a matricola
        Studente s = em.find(Studente.class, matricola);//i parametri sono la classe e la chiave primaria della classe che si vuole aggiornare
        return s;
    }
    public void delete(Studente studente){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(studente);
        et.commit();
    }

}
