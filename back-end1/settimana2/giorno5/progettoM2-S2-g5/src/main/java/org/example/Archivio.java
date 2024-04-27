package org.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Archivio {
    private static List<Catlogo> catalogo;
    static private File file = new File("./persistense/file.txt");

    public Archivio() {
        this.catalogo = new ArrayList<>();
    }

    public void add(Catlogo... c) {
        Set<String> isbnSet = catalogo.stream()
                .map(Catlogo::getISBN)
                .collect(Collectors.toSet());

        List<Catlogo> nuoviCataloghi = Arrays.stream(c)
                .filter(cat -> !isbnSet.contains(cat.getISBN()))
                .collect(Collectors.toList());

        catalogo.addAll(nuoviCataloghi);

        System.out.println("\nAggiunti:");
        nuoviCataloghi.forEach(System.out::println);
    }

    public void remove(Catlogo Catlogo) {
        catalogo.remove(Catlogo);
    }

    public List<Catlogo> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<Catlogo> catalogo) {
        this.catalogo = catalogo;
    }

    //cancella per Isbn
    public void cancellaByIsdn(String isbn) {
        /*catalogo.removeIf(c -> c.getISBN().equals(isbn));*/
        catalogo.removeAll(cercaIsbn(isbn));
        System.out.println("\n isbn" + isbn + " canecllato");
        catalogo.forEach(System.out::println);
    }

    //ricerca per Isbn
    public List<Catlogo> cercaIsbn(String isbn) {
        List<Catlogo> cercati = catalogo.stream().filter(c -> c.getISBN().equals(isbn)).toList();
        System.out.println("\nisbn cercato:" + isbn);
        cercati.forEach(System.out::println);
        if (cercati.size() == 0)
            System.out.println(" non trovato");
        return cercati;
    }


    //ricerca per anno di publicazione
    public void cercaAnnoPub(int anno) {
        System.out.println("\n  cercato per anno:" + anno);
        List<Catlogo> t = catalogo.stream().filter(c -> c.getPublicationDate().getYear() == anno).toList();
        t.forEach(System.out::println);
        if (t.size() == 0)
            System.out.println(" non trovato");
    }

    //ricerca per autore
    public void cercaAutore(String autore) {
        System.out.println("\ni libri dell'autore trovato");
        /*List<Catlogo> aut = catalogo.stream().filter(c -> c instanceof Libro && ((Libro) c).getAutore().toLowerCase().equals(autore.toLowerCase())).toList();*/
        /* aut.forEach(System.out::println);*/
        List<Catlogo> aut = catalogo.stream().filter(c -> c instanceof Libro && ((Libro) c).getAutore().toLowerCase().contains(autore.toLowerCase())).toList();
        aut.forEach(System.out::println);

        /* catalogo.stream().filter(c -> c instanceof Libro).filter(c -> ((Libro) c).getAutore().equals(autore)).forEach(System.out::println);*/
    }

    //salva su disco
    public void save() throws IOException {

        String strFile = catalogo.stream()
                .map(Object::toString).collect(Collectors.joining("#"));
        try {
            FileUtils.writeStringToFile(this.file, strFile, Charset.defaultCharset(), false);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("\n file salvato");
            catalogo.forEach(System.out::println);
        }
    }

    //carica da disco
    public List<Catlogo> carica() throws IOException {
        List<Catlogo> catal = new ArrayList<>();
        try {
            System.out.println("\n file caricato");
            String str = FileUtils.readFileToString(this.file, Charset.defaultCharset());
            catal = Arrays.stream(str.split("#"))
                    .map(s -> s.split("@", 0))
                    .map(split -> {
                        String n = split[0];
                        switch (n.charAt(11)) {
                            case '1': // Carica il libro
                                return new Libro(split[0], split[1], LocalDate.parse(split[2]), Integer.parseInt(split[3]), split[4], split[5]);
                            case '2':
                                return new Riviste(split[0], split[1], LocalDate.parse(split[2]), Integer.parseInt(split[3]), Periodicita.valueOf(split[4]));
                            default:
                                throw new IllegalArgumentException("Caso non valido: " + n.charAt(11));
                        }
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //catal.stream().forEach(System.out::println);
            return catal;
        }

    }

    @Override
    public String toString() {
        return "Archivio{" +
                "catalogo=" + catalogo +
                '}';
    }
}
