package it.epidocode.EsercizioU5s2s2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    @Size(min = 3, max = 20, message = "Nome deve essere tra 3 e 20 caratteri")
    private String nome;
    @NotNull
    @Size(min = 3, max = 20, message = "Nome deve essere tra 3 e 20 caratteri")
    private String cognome;
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "L'email inserita non è valida")
    @NotBlank
    private String email;
    @NotNull
    private LocalDate dataDiNascita;
    @NotBlank
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
