package it.dispositiviAziendali.pgM5S2G5.model.dispositivi;

import it.dispositiviAziendali.pgM5S2G5.enums.EnumTipoSensore;
import it.dispositiviAziendali.pgM5S2G5.model.Dispositivo;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "domotica")
public class Domotica extends Dispositivo {
    @Enumerated(EnumType.STRING)
    private EnumTipoSensore sensore;
    private String compatibilita;
    private String descrizione;

}
