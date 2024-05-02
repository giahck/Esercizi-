package esercizio.eventi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class PartitaDicalcio extends Eventi{
    @Column(name = "squadra_casa")
    private String squadraCasa;
    @Column(name = "squadra_ospite")
    private String squadraOspite;
    @Column(name = "squadra_vincite")
    private String squadraVincite;
    @Column(name = "goal_casa")
    private int goalCasa;
    @Column(name = "goal_ospite")
    private int goalOspite;
    public PartitaDicalcio() {
    }
    public PartitaDicalcio(String titolo, LocalDate dataEvento, String descrizione, tipoEvento tipoEvento, int numeroPartecipanti, Location location, String squadraCasa, String squadraOspite, String squadraVincite, int goalCasa, int goalOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroPartecipanti);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincite = squadraVincite;
        this.goalCasa = goalCasa;
        this.goalOspite = goalOspite;
    }

}
