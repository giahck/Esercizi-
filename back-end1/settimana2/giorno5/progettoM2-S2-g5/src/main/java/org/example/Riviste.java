package org.example;

import java.time.LocalDate;

public class Riviste extends Catlogo{
    private Periodicita periodicita;
    public Riviste(String ISBN, String title, LocalDate publicationDate, int pagine, Periodicita periodicita){
        super(ISBN, title, publicationDate, pagine);
        this.periodicita = periodicita;
    }
    public Periodicita getPeriodicita(){
        return periodicita;
    }
    public void setPeriodicita(Periodicita periodicita){
        this.periodicita = periodicita;
    }
    @Override
    public String toString(){
        return  ISBN + '@' +
                title + '@' +
                publicationDate +"@"
                + pagine +"@"
                + periodicita;
    }
}
