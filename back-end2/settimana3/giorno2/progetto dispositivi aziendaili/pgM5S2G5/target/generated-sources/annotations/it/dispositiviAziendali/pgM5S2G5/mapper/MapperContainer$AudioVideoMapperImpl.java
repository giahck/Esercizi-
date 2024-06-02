package it.dispositiviAziendali.pgM5S2G5.mapper;

import it.dispositiviAziendali.pgM5S2G5.model.Dipendente;
import it.dispositiviAziendali.pgM5S2G5.model.dispositivi.AudioVideo;
import it.dispositiviAziendali.pgM5S2G5.payloads.sottoclassdispositivo.AudioVideoDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-30T09:58:45+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class MapperContainer$AudioVideoMapperImpl implements MapperContainer.AudioVideoMapper {

    @Override
    public AudioVideo toAudioVideo(AudioVideoDTO audioVideoDto) {
        if ( audioVideoDto == null ) {
            return null;
        }

        AudioVideo audioVideo = new AudioVideo();

        audioVideo.setDipendente( audioVideoDTOToDipendente( audioVideoDto ) );
        audioVideo.setNome( audioVideoDto.getNome() );
        audioVideo.setMarca( audioVideoDto.getMarca() );
        audioVideo.setStatus( audioVideoDto.getStatus() );
        audioVideo.setTipoVideo( audioVideoDto.getTipoVideo() );
        audioVideo.setDimensione( audioVideoDto.getDimensione() );
        audioVideo.setDescrizione( audioVideoDto.getDescrizione() );

        return audioVideo;
    }

    @Override
    public AudioVideoDTO toAudioVideoDTO(AudioVideo audioVideo) {
        if ( audioVideo == null ) {
            return null;
        }

        AudioVideoDTO audioVideoDTO = new AudioVideoDTO();

        audioVideoDTO.setIdDipendente( audioVideoDipendenteId( audioVideo ) );
        audioVideoDTO.setNome( audioVideo.getNome() );
        audioVideoDTO.setMarca( audioVideo.getMarca() );
        audioVideoDTO.setStatus( audioVideo.getStatus() );
        audioVideoDTO.setTipoVideo( audioVideo.getTipoVideo() );
        audioVideoDTO.setDimensione( audioVideo.getDimensione() );
        audioVideoDTO.setDescrizione( audioVideo.getDescrizione() );

        return audioVideoDTO;
    }

    @Override
    public void updateAudioVideoFromDto(AudioVideoDTO audioVideoDto, AudioVideo audioVideo) {
        if ( audioVideoDto == null ) {
            return;
        }

        audioVideo.setNome( audioVideoDto.getNome() );
        audioVideo.setMarca( audioVideoDto.getMarca() );
        audioVideo.setStatus( audioVideoDto.getStatus() );
        audioVideo.setTipoVideo( audioVideoDto.getTipoVideo() );
        audioVideo.setDimensione( audioVideoDto.getDimensione() );
        audioVideo.setDescrizione( audioVideoDto.getDescrizione() );
    }

    protected Dipendente audioVideoDTOToDipendente(AudioVideoDTO audioVideoDTO) {
        if ( audioVideoDTO == null ) {
            return null;
        }

        Dipendente dipendente = new Dipendente();

        if ( audioVideoDTO.getIdDipendente() != null ) {
            dipendente.setId( audioVideoDTO.getIdDipendente() );
        }

        return dipendente;
    }

    private Integer audioVideoDipendenteId(AudioVideo audioVideo) {
        if ( audioVideo == null ) {
            return null;
        }
        Dipendente dipendente = audioVideo.getDipendente();
        if ( dipendente == null ) {
            return null;
        }
        int id = dipendente.getId();
        return id;
    }
}
