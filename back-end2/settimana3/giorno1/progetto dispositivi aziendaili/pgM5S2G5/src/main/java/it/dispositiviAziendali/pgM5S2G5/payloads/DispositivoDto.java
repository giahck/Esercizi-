package it.dispositiviAziendali.pgM5S2G5.payloads;

import it.dispositiviAziendali.pgM5S2G5.enums.StatusDispositivoEnum;
import it.dispositiviAziendali.pgM5S2G5.payloads.sottoclassdispositivo.AudioVideoDTO;
import it.dispositiviAziendali.pgM5S2G5.payloads.sottoclassdispositivo.DomoticaDTO;
import it.dispositiviAziendali.pgM5S2G5.payloads.sottoclassdispositivo.InformaticaDTO;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AudioVideoDTO.class, name = "audioVideo"),
        @JsonSubTypes.Type(value = DomoticaDTO.class, name = "domotica"),
        @JsonSubTypes.Type(value = InformaticaDTO.class, name = "informatica")
})
@Data
public abstract class DispositivoDto {
        @NotBlank(message = "Il campo nome non può essere vuoto")
        @Size(min = 3, max = 15, message = "Nome deve avere minimo 3 caratteri, massimo 15")
        private String nome;

        @NotBlank(message = "Il campo marca non può essere vuoto")
        @Size(min = 3, max = 30, message = "Marca deve avere minimo 3 caratteri, massimo 30")
        private String marca;

        @NotNull(message = "Il campo status non può essere vuoto")
        private StatusDispositivoEnum status;

        @NotNull(message = "idDipendente cannot be null")
        @Min(value = 1, message = "idDipendente must be greater than 0")
        private Integer idDipendente;
}
