package it.proggettoS1M5.GestionePrenotzioni.bean;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@SuperBuilder
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "nome")
    private List<String> nome;
    private String email;
    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazione;

}
