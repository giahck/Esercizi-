package it.epidocode.EsercizioU5s2s2.model;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Autore {
    private static int count;
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;//generato dal server

    public Autore(String nome, String cognome, String email, LocalDate dataDiNascita, String avatar) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.avatar = avatar+nome+"+"+cognome;
        this.id = count++;
    }
}
