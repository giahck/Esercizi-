package it.dispositiviAziendali.pgM5S2G5.payloads.sottoclassdispositivo;

import it.dispositiviAziendali.pgM5S2G5.enums.EnumTipoSensore;
import it.dispositiviAziendali.pgM5S2G5.payloads.DispositivoDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DomoticaDTO extends DispositivoDto {
    @NotNull(message = "Il tipo di sensore non può essere nullo")
    private EnumTipoSensore sensore;
    @NotBlank(message = "La compatibilità non può essere vuota")
    private String compatibilita;
    private String descrizione;
}

