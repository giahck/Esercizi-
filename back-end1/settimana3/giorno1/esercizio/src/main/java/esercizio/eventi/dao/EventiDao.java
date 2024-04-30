package esercizio.eventi.dao;

import esercizio.eventi.entity.Eventi;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventiDao {
    private EntityManager em;
    public EventiDao(EntityManager em) {
        this.em = em;
    }
    public void save(Eventi eventi){
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(eventi);
        t.commit();
    }
    public Eventi getById(int id){
        return em.find(Eventi.class, id);
    }
    public void delete(Eventi eventi){
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.remove(eventi);
        t.commit();
    }
}
