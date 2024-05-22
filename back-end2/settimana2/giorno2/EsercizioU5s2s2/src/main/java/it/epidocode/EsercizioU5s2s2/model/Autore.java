package it.epidocode.EsercizioU5s2s2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "autore")
public class Autore {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;//generato dal server

    @OneToMany(mappedBy = "autore")
    private List<Blog> blog;

    /*public Autore(String nome, String cognome, String email, LocalDate dataDiNascita, String avatar) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.avatar = avatar+nome+"+"+cognome;
    }*/
    public void initAvatar() {
        String firstName = this.nome.split("\\s+")[0];
        String lastName = this.cognome.split("\\s+")[0];
        this.avatar = "https://ui-avatars.com/api/?name=" + firstName + "+" + lastName;
    }
}
