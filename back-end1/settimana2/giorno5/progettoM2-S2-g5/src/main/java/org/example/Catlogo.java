package org.example;

import java.time.LocalDate;

public class Catlogo {
    protected  String ISBN;
    protected  String title;
    protected LocalDate publicationDate;
    protected int pagine;
    public Catlogo(String ISBN, String title, LocalDate publicationDate, int pagine){
        this.ISBN = ISBN;
        this.title = title;
        this.publicationDate = publicationDate;
        this.pagine = pagine;
    }
    public String getISBN(){
        return ISBN;
    }
    public String getTitle(){
        return title;
    }
    public LocalDate getPublicationDate(){
        return publicationDate;
    }
    public int getPagine(){
        return pagine;
    }
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setPublicationDate(LocalDate publicationDate){
        this.publicationDate = publicationDate;
    }
    public void setPagine(int pagine){
        this.pagine = pagine;
    }
    @Override
    public String toString(){
        return "Catlogo{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", publicationDate=" + publicationDate +
                ", pagine=" + pagine +
                '}';
    }
}

