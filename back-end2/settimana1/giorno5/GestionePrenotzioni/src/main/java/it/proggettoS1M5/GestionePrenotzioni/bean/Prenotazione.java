package it.proggettoS1M5.GestionePrenotzioni.bean;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@Entity
@Table(name = "prenotazione")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private LocalDate data;

    @OneToOne
    @JoinColumn(name = "id_postazione")
    private Postazione postazione;
    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;
}
