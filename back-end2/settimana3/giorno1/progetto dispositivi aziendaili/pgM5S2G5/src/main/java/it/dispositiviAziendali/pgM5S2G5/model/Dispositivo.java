package it.dispositiviAziendali.pgM5S2G5.model;

import it.dispositiviAziendali.pgM5S2G5.enums.StatusDispositivoEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "dispositivi")
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID matricola;
    private String nome;
    private String marca;
    @Enumerated(EnumType.STRING)
    private StatusDispositivoEnum status;


    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;
}
