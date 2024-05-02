package PM4_S3_G5.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "numero_di_tessera", unique = true, nullable = false)
    private UUID numeroDiTessera;

    private String nome;
    private String cognome;
    @Column(name = "data_di_nascita")
    private LocalDate dataDiNascita;


    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti;

    public Utente(String nome, String cognome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        // this.numeroDiTessera = UUID.randomUUID();//genera un numero di tessera randomico ad ogni istanza
    }

    public Utente() {
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

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public UUID getNumeroDiTessera() {
        return numeroDiTessera;
    }

    public void setNumeroDiTessera(UUID numeroDiTessera) {
        this.numeroDiTessera = numeroDiTessera;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", numeroDiTessera=" + numeroDiTessera +
                /*", prestiti=" + prestiti +*/
                '}';
    }
}
