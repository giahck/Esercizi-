package PM4_S3_G5.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "catalogo")
public abstract class Catalogo {
    @Id
    @GeneratedValue
    private UUID isbn;

    private String titolo;
    @Column(name = "data_pubblicazione")
    private LocalDate dataPubblicazione;
    @Column(name = "numero_pagine")
    private int numeroPagine;

    @OneToMany(mappedBy = "catalogo")
    private List<Prestito> prestiti;

    public  Catalogo() {
    }
    public Catalogo(String titolo, LocalDate dataPubblicazione, int numeroPagine) {
        this.titolo = titolo;
        this.dataPubblicazione = dataPubblicazione;
        this.numeroPagine = numeroPagine;
    }
    public void setCatalogo(UUID isbn) {
        this.isbn = isbn;
    }

    public UUID getIsbn() {
        return isbn;
    }
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public LocalDate getDataPubblicazione() {
        return dataPubblicazione;
    }
    public void setDataPubblicazione(LocalDate dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }
    public int getNumeroPagine() {
        return numeroPagine;
    }
    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }
    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", dataPubblicazione=" + dataPubblicazione +
                ", numeroPagine=" + numeroPagine +
               /* ", prestiti=" + prestiti +*/
                '}';
    }
}
