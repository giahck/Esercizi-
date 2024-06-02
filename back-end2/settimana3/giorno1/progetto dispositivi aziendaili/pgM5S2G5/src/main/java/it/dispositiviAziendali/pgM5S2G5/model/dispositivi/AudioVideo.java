package it.dispositiviAziendali.pgM5S2G5.model.dispositivi;

import it.dispositiviAziendali.pgM5S2G5.enums.EnumTipoVideo;
import it.dispositiviAziendali.pgM5S2G5.model.Dispositivo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "audio_video")
public class AudioVideo extends Dispositivo {
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_di_video")
    private EnumTipoVideo tipoVideo;
    private int dimensione;
    private String descrizione;
}
