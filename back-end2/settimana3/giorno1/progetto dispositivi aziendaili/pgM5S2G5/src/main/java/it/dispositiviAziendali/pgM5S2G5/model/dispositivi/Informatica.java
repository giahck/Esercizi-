package it.dispositiviAziendali.pgM5S2G5.model.dispositivi;

import it.dispositiviAziendali.pgM5S2G5.enums.EnumTipoDiComputer;
import it.dispositiviAziendali.pgM5S2G5.model.Dispositivo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "informatica")
public class Informatica extends Dispositivo {
    @Enumerated(EnumType.STRING)
    private EnumTipoDiComputer tipoDiComputer;
    private String processore;
    private int ram;
    private String archiviazione;
}
