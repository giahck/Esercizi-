package esercizio.eventi.entity;

import javax.persistence.*;

@Entity
@Table(name = "partecipazione")
public class Partecipazioni {
    @Id
    @GeneratedValue
    private int id;
    //molte istanze di "Partecipazioni" sono associate a un'istanza di "Persone".
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persone persone;
    //relazione molti a uno con (un evento può avere molte partecipazioni)
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Eventi evento;

    @Enumerated(EnumType.STRING)
    private epicode.entities.Stato stato;

    public Partecipazioni() {
    }

    public Partecipazioni(Persone persone, Eventi evento) {
        this.persone = persone;
        this.evento = evento;
        this.stato = epicode.entities.Stato.DA_CONFERMARE;
    }

    public int getId() {
        return id;
    }

    public Persone getPersone() {
        return persone;
    }

    public void setPersone(Persone persone) {
        this.persone = persone;
    }

    public Eventi getEventi() {
        return evento;
    }

    public void setEventi(Eventi evento) {
        this.evento = evento;
    }

    public epicode.entities.Stato getStato() {
        return stato;
    }

    public void setStato(epicode.entities.Stato stato) {
        this.stato = stato;
    }
    @Override
    public String toString() {
        return "Partecipazioni{" +
                "id=" + id +
                ", persone=" + persone +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }


}
