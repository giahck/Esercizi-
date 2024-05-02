package epicode.dao;

import epicode.entity.ClasseStudenti;
import epicode.entity.Corso;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CorsoDao {
    private EntityManager em;
    public CorsoDao(EntityManager em) {
        this.em = em;
    }
    public void save(Corso corso){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(corso);
        et.commit();
    }
    public Corso getById(int id){
        Corso corso = em.find(Corso.class,id);
        return corso;
    }
    public void delete(Corso corso){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(corso);
        et.commit();
    }
}
