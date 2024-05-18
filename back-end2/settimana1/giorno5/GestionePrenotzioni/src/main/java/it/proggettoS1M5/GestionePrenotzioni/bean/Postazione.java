package it.proggettoS1M5.GestionePrenotzioni.bean;

import it.proggettoS1M5.GestionePrenotzioni.Enum.EnumPostazione;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "postazione")
//@Table(name = "postazione",uniqueConstraints = @UniqueConstraint(columnNames = {"postazione_id", "data"}))//vincolo di unicità per la coppia postazione_id e data
public class Postazione extends Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  //  @Column(name = "id_postazione")
    private UUID id;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private EnumPostazione tipo;

    @Column(name = "max_posti")
    private int maxPosti;

    @OneToOne(mappedBy = "postazione")
    private Prenotazione prenotazione;
    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", tipo=" + tipo +
                // other fields except Prenotazione
                '}';
    }
}
