package esercizio.eventi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String Citta;
    public Location() {
    }
    public Location(String nome, String citta) {
        this.nome = nome;
        Citta = citta;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCitta() {
        return Citta;
    }
    public void setCitta(String citta) {
        Citta = citta;
    }
    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", Citta='" + Citta + '\'' +
                '}';
    }


}
