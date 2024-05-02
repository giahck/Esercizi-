package esercizio.eventi.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class GaradiAtletica extends Eventi{

    @ManyToMany(mappedBy = "gareDiAtletica")
    private Set<Persone>atleti;
    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Persone vincitore;
    public GaradiAtletica() {
    }
    public GaradiAtletica(String titolo, LocalDate dataEvento, String descrizione, tipoEvento tipoEvento, int numeroPartecipanti, Location location, Set<Persone> atleti, Persone vincitore ) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroPartecipanti);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

}
