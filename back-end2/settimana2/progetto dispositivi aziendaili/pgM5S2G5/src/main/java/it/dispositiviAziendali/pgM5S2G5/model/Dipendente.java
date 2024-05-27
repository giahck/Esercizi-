package it.dispositiviAziendali.pgM5S2G5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@ToString
@Table(name = "dipendenti")
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String fotoProfilo;
    @OneToMany(mappedBy = "dipendente")
    @JsonIgnore
    private List<Dispositivo> dispositivi;
}
