package PM4_S3_G5.dao;

import PM4_S3_G5.entities.Catalogo;
import PM4_S3_G5.entities.Prestito;
import PM4_S3_G5.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class UtenteDao {
    private EntityManager em;

    public UtenteDao(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(utente);
            et.commit();
            System.out.println("Utente " + utente.getNome() + " " + utente.getCognome() + " creato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Utente findById(String ntessera) {
        ;
        return em.find(Utente.class, UUID.fromString(ntessera));
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction et = em.getTransaction();
            Utente found = em.find(Utente.class, id);
            if (found != null) {
                et.begin();
                em.remove(found);
                et.commit();
                System.out.println("Utente eliminato");
            } else System.out.println("Utente non trovato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveAll(List<Utente> utenti) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            for (Utente utente : utenti) {
                em.persist(utente);
            }
            et.commit();
            System.out.println("Utenti salvati con successo");
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            System.out.println("Errore durante il salvataggio degli utenti: " + e.getMessage());
        }
    }
    //SELECT c.titolo,u.nome FROM prestito p JOIN catalogo c ON p.prestito_isbn = c.isbn
    // JOIN Utente u ON p.id_utente = u.numero_di_tessera WHERE u.numero_di_tessera = '440ba533-790f-4039-b865-1d294049533e';
    public List<Prestito> getPrestitiUtente(String numeroTessera){
        UUID uuid = UUID.fromString(numeroTessera);
        Query query = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroDiTessera = :numeroTessera");
        query.setParameter("numeroTessera", uuid);
        return query.getResultList();
    }
    public List<Prestito> getPrestitiScaduti() {
        Query query = em.createQuery("SELECT p FROM Prestito p WHERE p.dataFinePrestito IS NULL AND p.dataInizioPrestito <= :maxDate AND p.dataInizioPrestito >= :minDate");
        LocalDate maxDate = LocalDate.now();
        LocalDate minDate = maxDate.minusDays(30);
        query.setParameter("maxDate", maxDate);
        query.setParameter("minDate", minDate);
        return query.getResultList();
    }
}
