package PM4_S3_G5.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "prestito")
public class Prestito {
    @Id
    @GeneratedValue
    private int id;
    //un utente può avere più prestiti
    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;
    //un libro o una rivista può essere prestato più volte
    @ManyToOne
    @JoinColumn(name = "prestito_isbn")
    private Catalogo catalogo;

    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;
    //la data di fine prestito è dataInizio + 30 giorni
    @Column(name = "data_fine_prestito")
    private LocalDate dataFinePrestito;
    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    public Prestito(Utente utente, Catalogo catalogo, LocalDate dataInizioPrestito, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.catalogo = catalogo;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
        this.dataFinePrestito = dataInizioPrestito.plusDays(30);
    }

    public Prestito() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Catalogo getPrestito() {
        return catalogo;
    }

    public void setPrestito(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataFinePrestito() {
        return dataFinePrestito;
    }

    public void setDataFinePrestito(LocalDate dataFinePrestito) {
        this.dataFinePrestito = dataFinePrestito;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettivaPrestito(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", catalogo=" + catalogo +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataFinePrestito=" + dataFinePrestito +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
