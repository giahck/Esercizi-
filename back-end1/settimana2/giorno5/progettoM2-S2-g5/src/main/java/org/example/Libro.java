package org.example;

import java.time.LocalDate;

public class Libro extends Catlogo{
    private String autore;
    private String editore;
    private String genere;
    public Libro(String ISBN, String title, LocalDate publicationDate, int pagine, String autore, String genere){
        super(ISBN, title, publicationDate, pagine);
        this.autore = autore;
        this.genere = genere;
    }
    public String getAutore(){
        return autore;
    }
    public String getEditore(){
        return editore;
    }
    public String getGenere(){
        return genere;
    }
    public void setAutore(String autore){
        this.autore = autore;
    }
    public void setEditore(String editore){
        this.editore = editore;
    }
    public void setGenere(String genere){
        this.genere = genere;
    }

    @Override
    public String toString(){
        return  ISBN + '@'
                + title + '@'
                + publicationDate +"@"
                + pagine + "@"
                + autore + '@'
                + genere ;
    }
}
