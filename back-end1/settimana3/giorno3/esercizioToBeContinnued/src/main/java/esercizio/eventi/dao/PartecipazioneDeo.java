package esercizio.eventi.dao;

import esercizio.eventi.entity.Eventi;
import esercizio.eventi.entity.Location;
import esercizio.eventi.entity.Partecipazioni;
import esercizio.eventi.entity.Persone;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

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
    public List<Persone> getPersonaByEvento(Eventi eventi){
        Query query = em.createNamedQuery("getPersonaByEvento");
        query.setParameter("evento", eventi);
        List<Persone> result = query.getResultList();
        return result;
    }
    public Long countPersonaByCount(Eventi eventi){
        Query query = em.createQuery("select count(p) from Partecipazioni p where p.evento=:evento");
        query.setParameter("evento", eventi);
        Long result = (Long) query.getSingleResult();
        return result;
    }
}
