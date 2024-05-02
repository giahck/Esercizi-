package esercizio.eventi.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Eventi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "eventi_id_sequence")
//con questa annotazione si dice che la chiave primaria è generata automaticamente dal database
    @SequenceGenerator(name = "eventi_id_sequence", sequenceName = "eventi_id_sequence", initialValue = 1, allocationSize = 1)
    private int id;
    @Column(nullable = false, length = 30)
    private String titolo;
    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento")
    private tipoEvento tipoEvento;
    private int numeroPartecipanti;

    public Eventi(int id, String titolo, LocalDate dataEvento, String descrizione, tipoEvento tipoEvento, int numeroPartecipanti) {
        this.id = id;
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroPartecipanti = numeroPartecipanti;
    }

    public Eventi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public tipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(tipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroPartecipanti() {
        return numeroPartecipanti;
    }

    public void setNumeroPartecipanti(int numeroPartecipanti) {
        this.numeroPartecipanti = numeroPartecipanti;
    }

    @Override
    public String toString() {
        return "Eventi{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroPartecipanti=" + numeroPartecipanti +
                '}';
    }

}
