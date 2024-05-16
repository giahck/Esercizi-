package it.epicode.u5S2G4.bean;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Dispositivo {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String marca;

    @ManyToMany
    @JoinColumn(name = "studente_id")
    private Studente studente;
}
