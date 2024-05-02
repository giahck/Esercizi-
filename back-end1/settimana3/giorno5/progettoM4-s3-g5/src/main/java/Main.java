import PM4_S3_G5.dao.CatalogoDao;
import PM4_S3_G5.dao.PrestitoDao;
import PM4_S3_G5.dao.UtenteDao;
import PM4_S3_G5.entities.*;
import PM4_S3_G5.tipoEnum.Periodicita;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    //   private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pgM4_S3_g5");
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pgM4_S3_g5");
        EntityManager em = emf.createEntityManager();
        Libro libro1 = new Libro("Il signore degli anelli", LocalDate.of(1954, 7, 29), 1000, "J.R.R. Tolkien", "Fantasy");
        Libro libro2 = new Libro("Il trono di spade", LocalDate.of(1996, 8, 6), 1000, "George R.R. Martin", "Fantasy");
        Libro libro3 = new Libro("Il nome della rosa", LocalDate.of(1980, 1, 1), 1000, "Umberto Eco", "Giallo");
        Libro libro4 = new Libro("Il vecchio e il mare", LocalDate.of(1952, 9, 1), 1000, "Ernest Hemingway", "Romanzo");
        Libro libro5 = new Libro("Dragon Ball", LocalDate.of(1984, 11, 20), 1000, "Akira Toriyama", "Manga");
        Libro libro6 = new Libro("Naruto", LocalDate.of(1999, 9, 21), 1000, "Masashi Kishimoto", "Manga");

        Rivista rivista1 = new Rivista("Vanity Fair", LocalDate.of(1983, 3, 1), 100, Periodicita.SETTIMANALE);
        Rivista rivista2 = new Rivista("Panorama", LocalDate.of(1952, 10, 30), 100, Periodicita.SETTIMANALE);
        Rivista rivista3 = new Rivista("National Geographic", LocalDate.of(1888, 10, 1), 100, Periodicita.MENSILE);
        Rivista rivista4 = new Rivista("Focus", LocalDate.of(1992, 1, 1), 100, Periodicita.MENSILE);
        Rivista rivista5 = new Rivista("Avengers", LocalDate.of(1997, 1, 5), 650, Periodicita.ANNUALE);

        Utente utente1 = new Utente("Mario", "Rossi", LocalDate.of(1994, 5, 4));
        Utente utente2 = new Utente("Luca", "Verdi", LocalDate.of(1994, 5, 4));
        Utente utente3 = new Utente("Giovanni", "Bianchi", LocalDate.of(1994, 5, 4));
        Utente utente4 = new Utente("Paolo", "Neri", LocalDate.of(1994, 5, 4));


        CatalogoDao catalogoDao = new CatalogoDao(em);
        PrestitoDao prestitoDao = new PrestitoDao(em);
        UtenteDao utenteDao = new UtenteDao(em);
        //insert utente
//         utenteDao.saveAll(List.of(utente1,utente2,utente3,utente4));
//////       //insert catalogo
//        catalogoDao.saveAll(List.of(libro1,libro2,libro3,libro4,libro5,libro6,rivista1,rivista2,rivista3,rivista4,rivista5));
////
//        Prestito p1=new Prestito(utente1,libro1,LocalDate.now(),LocalDate.now().plusDays(10));
//        Prestito p2=new Prestito(utente2,libro2,LocalDate.now(),LocalDate.now().plusDays(30));
//        Prestito p3=new Prestito(utente3,libro3,LocalDate.now(),LocalDate.now().plusDays(25));
//        Prestito p4=new Prestito(utente4,libro4,LocalDate.now(),LocalDate.now().plusDays(11));
//
//        Prestito p5=new Prestito(utente1,libro5,LocalDate.now(),LocalDate.now().plusDays(5));
//        Prestito p6=new Prestito(utente2,libro6,LocalDate.now(),LocalDate.now().plusDays(15));
//        Prestito p7=new Prestito(utente4,libro2,LocalDate.now(),LocalDate.now().plusDays(10));
//
//        Prestito p8=new Prestito(utente1,rivista1,LocalDate.now(),LocalDate.now().plusDays(10));
//        Prestito p9=new Prestito(utente2,rivista2,LocalDate.now(),LocalDate.now().plusDays(30));
//        Prestito p10=new Prestito(utente3,rivista3,LocalDate.now(),LocalDate.now().plusDays(25));
//        Prestito p11=new Prestito(utente4,rivista4,LocalDate.now(),LocalDate.now().plusDays(11));
//        Prestito p12=new Prestito(utente1,rivista5,LocalDate.now(),LocalDate.now().plusDays(5));
//        prestitoDao.saveAll(List.of(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12));
        //   System.out.println(catalogoDao.findById("6672dfdc-dff4-4226-a517-d7d65497798b"));
        //   System.out.println(utenteDao.findById("00cd6458-dd5c-4ab0-84ad-aa7f685198bc"));

        // ricerca di un isbn nel catalogo
        System.out.println("\n---------------------ricerca per isbn------------------");
        Catalogo catRicercaIsbn = catalogoDao.findById("2078bd86-155c-4858-a12f-814b67784998");
        System.out.println(catRicercaIsbn);

        // delete di un isbn nel catalogo
        //  catalogoDao.deleteByIsbn("df803f52-d2f8-4492-a49b-d77157fccb69");

        //ricerca per anno di publicazione
        System.out.println("\n---------------------ricerca per anno di publicazione-------------------");
        List<Catalogo> c1 = catalogoDao.getAnnoPub(1997);
        //c1.forEach(System.out::println); stampa uguale settato il toString in super
        List<Catalogo> libriRivisteAnno = c1.stream()
                .filter(catalogo -> catalogo instanceof Libro || catalogo instanceof Rivista)
                .collect(Collectors.toList());
        libriRivisteAnno.forEach(System.out::println);

        //ricerca per autore
        System.out.println("\n--------------------------ricerca per autore-----------------------");
        List<Catalogo> c2 = catalogoDao.getAutore("J.R.R. Tolkien");//J.R.R. Tolkien
        c2.forEach(System.out::println);

        //ricerca per titolo
        System.out.println("\n------------------------ricerca per titolo-------------------------");
        List<Catalogo> c3 = catalogoDao.getTitolo("il");
        c3.forEach(System.out::println);
        //ricerca elemnti in prestito dato un numero di tessera dell'utente
        System.out.println("\n------------------------ricerca elemnti in prestito dato un numero di tessera dell'utente-------------------------");
        List<Prestito> c4 = utenteDao.getPrestitiUtente("440ba533-790f-4039-b865-1d294049533e");
        c4.stream()
                .map(prestito -> "Utente: " + prestito.getUtente().getNome() + ", Titolo: " + prestito.getPrestito().getTitolo())
                .forEach(System.out::println);
        //ricerca dei prestiti scaduti +30 giorni
        System.out.println("\n------------------------ricerca dei prestiti scaduti +30 giorni-------------------------");
        List<Prestito> c5 = utenteDao.getPrestitiScaduti();
        c5.stream()
                .map(prestito -> "Utente: " + prestito.getUtente().getNome() + ", Titolo: " + prestito.getPrestito().getTitolo())
                .forEach(System.out::println);
    }
}