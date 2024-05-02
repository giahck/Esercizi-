package PM4_S3_G5.dao;

import PM4_S3_G5.entities.Catalogo;
import PM4_S3_G5.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class CatalogoDao {
    private EntityManager em;

    public CatalogoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Catalogo catalogo) {
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(catalogo);
            et.commit();
            System.out.println("Catalogo " + catalogo.getTitolo() + " creato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //cerca un elemento nel database tramite la chiave primaria isbn
    public Catalogo findById(String isbn) {
        UUID uuid = UUID.fromString(isbn);
        return em.find(Catalogo.class, uuid);
    }

    public void Delete(String isbn) {
        UUID uuid = UUID.fromString(isbn);
        try {
            EntityTransaction et = em.getTransaction();
            //vedo prima se esiste
            Catalogo found = em.find(Catalogo.class, uuid);
            if (found != null) {
                et.begin();
                em.remove(found);
                et.commit();
                System.out.println("Elemento nel catalogo eliminato");
            } else System.out.println("Elemento nel catalogo non trovato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (em != null && em.isOpen()) { // Controlla se l'EntityManager è aperto prima di chiuderlo
                em.close(); // Chiudi l'EntityManager qui
            }
        }
    }

    public void saveAll(List<Catalogo> catalogo) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            for (Catalogo catalog : catalogo) {
                em.persist(catalog);
            }
            et.commit();
            System.out.println("Utenti salvati con successo");
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            System.out.println("Errore durante il salvataggio degli catalogo: " + e.getMessage());
        }
    }

    public void deleteByIsbn(String isbnCod) {
        UUID uuid = UUID.fromString(isbnCod);
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            //elimino i prestiti associati al catalogo
            Query delQueryPrestito = em.createQuery("Delete from Prestito p where p.catalogo.isbn= :isbn");
            delQueryPrestito.setParameter("isbn", uuid);
            delQueryPrestito.executeUpdate();
            //elimino elementi nel catalogo
            Query query = em.createQuery("DELETE FROM Catalogo c WHERE c.isbn = :isbn");
            query.setParameter("isbn", uuid);
            if (query.executeUpdate() == 0) {
                System.out.println("Nessun catalogo trovato con l'ISBN: " + isbnCod);
            } else {
                System.out.println("Catalogo eliminato con successo");
            }
            et.commit();

        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            System.out.println("Errore durante l'eliminazione del catalogo: " + e.getMessage());
        }
    }

    //SELECT * FROM catalogo WHERE EXTRACT(YEAR FROM data_pubblicazione) = 1997; sql query
    public List<Catalogo> getAnnoPub(int anno) {
        Query q = em.createQuery("SELECT c FROM Catalogo c WHERE YEAR(c.dataPubblicazione) = :anno");
        q.setParameter("anno", anno);
        return q.getResultList();
    }

    //select c.*, l.* from catalogo c inner join libro l On c.isbn=l.isbn where l.autore Like '%a%'; sql query
    public List<Catalogo> getAutore(String autore) {
        Query q = em.createQuery("SELECT l FROM Libro l WHERE l.autore LIKE :autore");
        //  q.setParameter("autore","%"+autore+"%");
        q.setParameter("autore", autore);
        return q.getResultList();
    }

    public List<Catalogo> getTitolo(String titolo) {
        Query q = em.createQuery("SELECT c  FROM Catalogo c WHERE c.titolo LIKE :titolo");
        q.setParameter("titolo", "%" + titolo + "%");
        return q.getResultList();
    }



}
