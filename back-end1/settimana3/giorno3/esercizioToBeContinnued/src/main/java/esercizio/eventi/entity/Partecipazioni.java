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
    private Eventi eventi;

    @Enumerated(EnumType.STRING)
    private epicode.entities.Stato stato;

    public Partecipazioni() {
    }

    public Partecipazioni(Persone persone, Eventi eventi) {
        this.persone = persone;
        this.eventi = eventi;
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
        return eventi;
    }

    public void setEventi(Eventi eventi) {
        this.eventi = eventi;
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
                ", eventi=" + eventi +
                ", stato=" + stato +
                '}';
    }


}
