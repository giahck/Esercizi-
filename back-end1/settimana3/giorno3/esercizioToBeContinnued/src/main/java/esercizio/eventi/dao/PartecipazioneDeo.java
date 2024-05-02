package esercizio.eventi.dao;

import esercizio.eventi.entity.Location;
import esercizio.eventi.entity.Partecipazioni;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDeo {
    private EntityManager em;
    public PartecipazioneDeo(EntityManager em) {
        this.em = em;
    }
    public void save(Partecipazioni partecipazioni){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(partecipazioni);
        et.commit();
    }
    public Partecipazioni getById(int id){
         return em.find(Partecipazioni.class,id);
    }
    public void delete(Partecipazioni partecipazioni){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(partecipazioni);
        et.commit();
    }
}
