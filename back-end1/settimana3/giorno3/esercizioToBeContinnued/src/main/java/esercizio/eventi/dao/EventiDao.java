package esercizio.eventi.dao;

import esercizio.eventi.entity.Eventi;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Stream;

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
    public void update(Eventi eventi){
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(eventi);
        t.commit();
    }
    public List<Eventi> query(){
        // Utilizzo di una query SQL diretta con createNativeQuery()
        Query query = em.createNativeQuery("SELECT * FROM Eventi", Eventi.class);
        query.setFirstResult(0);
        query.setMaxResults(10);
        // Eseguire la query e ottenere la lista dei risultati
        List<Eventi> result = query.getResultList();
        return  result;
    }
}
