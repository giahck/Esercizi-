package it.dispositiviAziendali.pgM5S2G5.payloads.sottoclassdispositivo;

import it.dispositiviAziendali.pgM5S2G5.enums.EnumTipoVideo;
import it.dispositiviAziendali.pgM5S2G5.payloads.DispositivoDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class AudioVideoDTO extends DispositivoDto {
    @NotNull(message = "Il tipo di video non può essere nullo")
    private EnumTipoVideo tipoVideo;

    @NotNull(message = "La dimensione non può essere vuota")

    @NotBlank(message = "La dimensione non può essere vuota")

    @Min(value = 4, message = "La dimensione deve essere maggiore di 0")
    private int dimensione;
    private String descrizione;
}