package epicode.dao;

import epicode.entity.ClasseStudenti;
import epicode.entity.Indirizzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ClasseDao {
    private EntityManager em;
    public ClasseDao(EntityManager em) {
        this.em = em;
    }
    public void save(ClasseStudenti classeStudenti){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(classeStudenti);
        et.commit();
    }
    public ClasseStudenti getById(int id){
        ClasseStudenti classeStudenti = em.find(ClasseStudenti.class,id);
        return classeStudenti;
    }
    public void delete(ClasseStudenti classeStudenti){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(classeStudenti);
        et.commit();
    }
}
