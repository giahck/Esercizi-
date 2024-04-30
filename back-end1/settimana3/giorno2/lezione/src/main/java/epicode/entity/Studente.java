package epicode.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "studente")
public class Studente {
    @Id//primary key in mysql database table column id di nome matricola
    @GeneratedValue//auto increment in mysql database table column id
    private int matricola;
    @Column(nullable = false, length = 30)//not null, unique = true non sono duplicati
    private String nome;
    @Column(nullable = false, length = 30)
    private String cognome;
    private String indirizzo;
    @Column(name =  "data_nascita")
    private LocalDate dataNascita;

    public Studente(int matricola, String nome, String cognome, String indirizzo, LocalDate dataNascita) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.dataNascita = dataNascita;
    }
    //costruttore vuoto per jpa hibernate che necessita di un costruttore vuoto per creare oggetti tramite reflection
    public Studente() { }
    public int getMatricola() {
        return matricola;
    }
    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public LocalDate getDataNascita() {
        return dataNascita;
    }
    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }
    @Override
    public String toString() {
        return "Studente{" +
                "matricola=" + matricola +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }

}
