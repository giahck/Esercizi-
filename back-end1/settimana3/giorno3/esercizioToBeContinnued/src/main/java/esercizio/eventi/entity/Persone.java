package esercizio.eventi.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "persona")
@NamedQuery(name="getPersonaByName",query="select p from Persone p where p.nome=:nome")
public class Persone {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate data_di_nascita;
    private char sesso;
    @OneToMany(mappedBy = "persone")
    private List<Partecipazioni> listaPartecipazioni;
    @OneToMany(mappedBy = "vincitore")
    private List<GaradiAtletica> gareVinte;
    @ManyToMany
    @JoinTable(name = "atleta_gara",
            joinColumns = @JoinColumn(name = "atleta_id"),
            inverseJoinColumns = @JoinColumn(name = "gara_id"))
    private List<GaradiAtletica> gareDiAtletica;

    public Persone() {
    }
    public Persone(String nome, String cognome, String email,LocalDate data_di_nascita , char sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.data_di_nascita = data_di_nascita;
        this.sesso = sesso;
    }

    public List<Partecipazioni> getListaPartecipazioni() {
        return listaPartecipazioni;
    }
    public void setListaPartecipazioni(List<Partecipazioni> listaPartecipazioni) {
        this.listaPartecipazioni = listaPartecipazioni;
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
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getData_di_nascita() {
        return data_di_nascita;
    }
    public void setData_di_nascita(LocalDate data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }
    public char getSesso() {
        return sesso;
    }
    public void setSesso(char sesso) {
        this.sesso = sesso;
    }
    @Override
    public String toString() {
        return "Persone{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", data_di_nascita='" + data_di_nascita + '\'' +
                ", sesso=" + sesso +
                '}';
    }

}
