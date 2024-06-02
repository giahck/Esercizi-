package Eventi.progettoEventi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "eventi")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Titolo;
    private String Descrizione;
    private LocalDateTime data;
    private String luogo;
    private int postiDisponibili;
   // private int postiOccupati; non uso il postiOccupati perchè posso calcolarlo in base al numero di utenti

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "eventi_utenti",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "utente_id")
    )
    private List<User> utenti;
    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", Titolo='" + Titolo + '\'' +
                ", Descrizione='" + Descrizione + '\'' +
                ", data=" + data +
                ", luogo='" + luogo + '\'' +
                ", postiDisponibili=" + postiDisponibili +
               // ", postiOccupati=" + postiOccupati +
                '}';
    }
}


