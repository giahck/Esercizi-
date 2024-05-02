package epicode.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    @Column(name = "data_nascita")
    private LocalDate dataNascita;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_studente")
    private TipoStudente tipoStudente;
    /*    @Embedded//indirizzo è un oggetto che viene mappato come una tabella indirizzo con i campi via, comune, provincia e chiave primaria matricola
        private Indirizzo indirizzo;*/
    @OneToOne//relazione uno a uno tra studente e indirizzo con chiave primaria indirizzo_id
    @JoinColumn(name = "indirizzo_id")
//nome della colonna che fa riferimento alla chiave primaria della tabella indirizzi foreign key
    private Indirizzo indirizzo;
    @ManyToOne
    @JoinColumn(name = "classe_studenti_id")
    private ClasseStudenti classeStudenti;

    @ManyToMany
    @JoinTable(name = "studenti_corsi", joinColumns = @JoinColumn(name = "studenti_id"), inverseJoinColumns = @JoinColumn(name = "corsi_id"))
    private List<Corso> corsi;

    public Studente(int matricola, String nome, String cognome, LocalDate dataNascita) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    //costruttore vuoto per jpa hibernate che necessita di un costruttore vuoto per creare oggetti tramite reflection
    public Studente() {
    }

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

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public TipoStudente getTipoStudente() {
        return tipoStudente;
    }

    public void setTipoStudente(TipoStudente tipoStudente) {
        this.tipoStudente = tipoStudente;
    }

    public ClasseStudenti getClasseStudenti() {
        return classeStudenti;
    }

    public void setClasseStudenti(ClasseStudenti classeStudenti) {
        this.classeStudenti = classeStudenti;
    }
    public List<Corso> getCorsi() {
        return corsi;
    }
    public void setCorsi(List<Corso> corsi) {
        this.corsi = corsi;
    }
   @Override
    public String toString() {
        return "Studente{" +
                "matricola=" + matricola +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", tipoStudente=" + tipoStudente +
                ", indirizzo=" + indirizzo +
                ", classeStudenti=" + classeStudenti +
                '}';
    }

}
