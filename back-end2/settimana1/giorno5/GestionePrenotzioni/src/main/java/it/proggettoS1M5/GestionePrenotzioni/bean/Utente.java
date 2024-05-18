package it.proggettoS1M5.GestionePrenotzioni.bean;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Builder
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Username;
    @Column(name = "nome")
    private List<String> nome;
    private String email;
    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazione;

}
