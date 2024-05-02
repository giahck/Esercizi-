package epicode.dao;

import epicode.entity.Indirizzo;
import epicode.entity.Studente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class IndirizzoDao {
    private EntityManager em;
    public IndirizzoDao(EntityManager em) {
        this.em = em;
    }
    public void save(Indirizzo indirizzo){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(indirizzo);
        et.commit();
    }
    public Indirizzo getById(int id){
        Indirizzo indirizzo = em.find(Indirizzo.class,id);
        return indirizzo;
    }
    public void delete(Indirizzo indirizzo){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(indirizzo);
        et.commit();
    }

}
