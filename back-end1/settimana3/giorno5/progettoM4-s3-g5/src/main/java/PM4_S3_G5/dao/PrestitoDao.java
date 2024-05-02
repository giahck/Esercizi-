package PM4_S3_G5.dao;

import PM4_S3_G5.entities.Catalogo;
import PM4_S3_G5.entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PrestitoDao {
    private EntityManager em;

    public PrestitoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(prestito);
            et.commit();
            System.out.println("Catalogo " + prestito.getPrestito() + " creato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Prestito findById(long id) {
        return em.find(Prestito.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction et = em.getTransaction();
            Prestito found = em.find(Prestito.class, id);
            if (found != null) {
                et.begin();
                em.remove(found);
                et.commit();
                System.out.println("Prestito eliminato");
            } else System.out.println("Prestito non trovato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveAll(List<Prestito> prestiti) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            for (Prestito prstito : prestiti) {
                em.persist(prstito);
            }
            et.commit();
            System.out.println("Prestiti salvati con successo");
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            System.out.println("Errore durante il salvataggio dei prestiti: " + e.getMessage());
        }
    }
}
