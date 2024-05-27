package it.dispositiviAziendali.pgM5S2G5.payloads.sottoclassdispositivo;

import it.dispositiviAziendali.pgM5S2G5.enums.EnumTipoDiComputer;
import it.dispositiviAziendali.pgM5S2G5.payloads.DispositivoDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class InformaticaDTO extends DispositivoDto {
    @NotNull(message = "Il tipo di computer non può essere nullo")
    private EnumTipoDiComputer tipoDiComputer;
    private String processore;
    private int ram;
    private String archiviazione;
}