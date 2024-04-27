package org.example;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        Catlogo libro= new Libro("1111111000010", "Il signore degli anelli", LocalDate.of(1954, 7, 29), 1000, "J.R.R. Tolkien", "Fantasy");
        Catlogo libro2=new Libro("1111111000011", "herry potter", LocalDate.of(1997, 6, 26), 1000, "J.K. Rowling", "Fantasy");
        Catlogo libro3=new Libro("1111111000012", "Il nome della rosa", LocalDate.of(1950, 1, 1), 1000, "Umberto Eco", "Giallo");
        Catlogo libro4=new Libro("1111111000013", "Il vecchio e il mare", LocalDate.of(1952, 9, 1), 1000, "Ernest Hemingway", "Romanzo");
        Catlogo libro5=new Libro("1111111000017", "Dragon Ball", LocalDate.of(1984, 11, 20), 1000, "Akira Toriyama", "Manga");
        Catlogo libro6=new Libro("1111111000015", "Naruto", LocalDate.of(1999, 9, 21), 1000, "Masashi Kishimoto", "Manga");
        Catlogo libro7=new Libro("1111111000016", "One piece", LocalDate.of(1997, 7, 22), 1000, "Eiichiro Oda", "Manga");


        Catlogo rivista2 = new Riviste("1111111000020", "Panorama", LocalDate.of(1952, 10, 30), 100, Periodicita.SETTIMANALE);
        Catlogo rivista  = new Riviste("1111111000021", "Vanity Fair", LocalDate.of(1983, 3, 1), 100, Periodicita.SETTIMANALE);
        Catlogo rivista3 = new Riviste("1111111000022", "National Geographic", LocalDate.of(1888, 10, 1), 100, Periodicita.MENSILE);
        Catlogo rivista4 = new Riviste("1111111000023", "Focus", LocalDate.of(1992, 1, 1), 100, Periodicita.MENSILE);
        Catlogo rivista6 = new Riviste("1111111000025", "Guerre stellari", LocalDate.of(1977, 1, 1), 650, Periodicita.ANNUALE);
        Archivio archivio = new Archivio();
        archivio.add(libro, libro2, libro3, libro4, rivista, rivista2, rivista3, rivista4);

        //aggiunta di un elemento
        Catlogo rivista5 = new Riviste("1111111000024", "Avengers", LocalDate.of(1999, 1, 5), 650, Periodicita.ANNUALE);
        archivio.add(rivista5);
        //cancella elemento inserendo isbn
      //  archivio.cancellaByIsdn("1111111000023");
        //ricerca per isbn
       // archivio.cercaIsbn("1111111000021");
        //ricerca per hanno di publicazione
        //archivio.cercaAnnoPub(1992);
        //archivio.cercaAnnoPub(1952);
        //ricerca per autore
      //  archivio.cercaAutore("j");
        //slva su file
     //  archivio.save();
        archivio.getCatalogo().forEach(System.out::println);
        System.out.println("*******************");
        //carica da file//sovrascrive
       List<Catlogo> file= archivio.carica();
       // file.stream().forEach(System.out::println);
        file.stream().forEach(System.out::println);
        archivio.setCatalogo(file);
        archivio.add(rivista6);
        archivio.save();

    }
}