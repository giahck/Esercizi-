package esercizio.eventi.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
public class Concerto extends Eventi{
    @Enumerated(EnumType.STRING)
    private Genere genere;
    private boolean inStreaming;
    public Concerto() {
    }
    public Concerto(String titolo, LocalDate dataEvento, String descrizione, tipoEvento tipoEvento, int numeroPartecipanti, Location location, Genere genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroPartecipanti);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }
}

