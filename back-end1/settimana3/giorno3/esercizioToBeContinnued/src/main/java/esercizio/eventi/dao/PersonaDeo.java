package esercizio.eventi.dao;

import esercizio.eventi.entity.Partecipazioni;
import esercizio.eventi.entity.Persone;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDeo {
    private EntityManager em;
    public PersonaDeo(EntityManager em) {
        this.em = em;
    }
    public void save(Persone person){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(person);
        et.commit();
    }
    public Persone getById(int id){
        return em.find(Persone.class,id);
    }
    public void delete(Persone person){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(person);
        et.commit();
    }
}
