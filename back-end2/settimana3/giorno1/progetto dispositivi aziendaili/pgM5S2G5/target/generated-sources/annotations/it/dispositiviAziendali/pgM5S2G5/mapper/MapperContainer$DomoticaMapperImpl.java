package it.dispositiviAziendali.pgM5S2G5.mapper;

import it.dispositiviAziendali.pgM5S2G5.model.Dipendente;
import it.dispositiviAziendali.pgM5S2G5.model.dispositivi.Domotica;
import it.dispositiviAziendali.pgM5S2G5.payloads.sottoclassdispositivo.DomoticaDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-28T17:51:45+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class MapperContainer$DomoticaMapperImpl implements MapperContainer.DomoticaMapper {

    @Override
    public Domotica toDomotica(DomoticaDTO domoticaDto) {
        if ( domoticaDto == null ) {
            return null;
        }

        Domotica domotica = new Domotica();

        domotica.setDipendente( domoticaDTOToDipendente( domoticaDto ) );
        domotica.setNome( domoticaDto.getNome() );
        domotica.setMarca( domoticaDto.getMarca() );
        domotica.setStatus( domoticaDto.getStatus() );
        domotica.setSensore( domoticaDto.getSensore() );
        domotica.setCompatibilita( domoticaDto.getCompatibilita() );
        domotica.setDescrizione( domoticaDto.getDescrizione() );

        return domotica;
    }

    @Override
    public DomoticaDTO toDomoticaDTO(Domotica domotica) {
        if ( domotica == null ) {
            return null;
        }

        DomoticaDTO domoticaDTO = new DomoticaDTO();

        domoticaDTO.setIdDipendente( domoticaDipendenteId( domotica ) );
        domoticaDTO.setNome( domotica.getNome() );
        domoticaDTO.setMarca( domotica.getMarca() );
        domoticaDTO.setStatus( domotica.getStatus() );
        domoticaDTO.setSensore( domotica.getSensore() );
        domoticaDTO.setCompatibilita( domotica.getCompatibilita() );
        domoticaDTO.setDescrizione( domotica.getDescrizione() );

        return domoticaDTO;
    }

    @Override
    public void updateDomoticaFromDto(DomoticaDTO domoticaDto, Domotica domotica) {
        if ( domoticaDto == null ) {
            return;
        }

        domotica.setNome( domoticaDto.getNome() );
        domotica.setMarca( domoticaDto.getMarca() );
        domotica.setStatus( domoticaDto.getStatus() );
        domotica.setSensore( domoticaDto.getSensore() );
        domotica.setCompatibilita( domoticaDto.getCompatibilita() );
        domotica.setDescrizione( domoticaDto.getDescrizione() );
    }

    protected Dipendente domoticaDTOToDipendente(DomoticaDTO domoticaDTO) {
        if ( domoticaDTO == null ) {
            return null;
        }

        Dipendente dipendente = new Dipendente();

        if ( domoticaDTO.getIdDipendente() != null ) {
            dipendente.setId( domoticaDTO.getIdDipendente() );
        }

        return dipendente;
    }

    private Integer domoticaDipendenteId(Domotica domotica) {
        if ( domotica == null ) {
            return null;
        }
        Dipendente dipendente = domotica.getDipendente();
        if ( dipendente == null ) {
            return null;
        }
        int id = dipendente.getId();
        return id;
    }
}
