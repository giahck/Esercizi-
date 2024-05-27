package it.epidocode.lezioneU5s2s2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Studente {
    @Id
    @GeneratedValue
    private int matricola;
  //  private static int cont;
    private String nome, cognome;
    private LocalDate dataNascita;

    private String foto;

    private String email;

    @ManyToOne
    @JoinColumn(name="aula_id")
    @JsonIgnore
    private Aula aula;

    /*public Studente(String nome, String cognome, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
       // matricola = cont++;
    }*/
}
