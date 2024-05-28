package it.dispositiviAziendali.pgM5S2G5.mapper;

import it.dispositiviAziendali.pgM5S2G5.model.Dipendente;
import it.dispositiviAziendali.pgM5S2G5.model.dispositivi.Informatica;
import it.dispositiviAziendali.pgM5S2G5.payloads.sottoclassdispositivo.InformaticaDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-28T17:51:45+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class MapperContainer$InformaticaMapperImpl implements MapperContainer.InformaticaMapper {

    @Override
    public Informatica toInformatica(InformaticaDTO informaticaDto) {
        if ( informaticaDto == null ) {
            return null;
        }

        Informatica informatica = new Informatica();

        informatica.setDipendente( informaticaDTOToDipendente( informaticaDto ) );
        informatica.setNome( informaticaDto.getNome() );
        informatica.setMarca( informaticaDto.getMarca() );
        informatica.setStatus( informaticaDto.getStatus() );
        informatica.setTipoDiComputer( informaticaDto.getTipoDiComputer() );
        informatica.setProcessore( informaticaDto.getProcessore() );
        informatica.setRam( informaticaDto.getRam() );
        informatica.setArchiviazione( informaticaDto.getArchiviazione() );

        return informatica;
    }

    @Override
    public InformaticaDTO toInformaticaDTO(Informatica informatica) {
        if ( informatica == null ) {
            return null;
        }

        InformaticaDTO informaticaDTO = new InformaticaDTO();

        informaticaDTO.setIdDipendente( informaticaDipendenteId( informatica ) );
        informaticaDTO.setNome( informatica.getNome() );
        informaticaDTO.setMarca( informatica.getMarca() );
        informaticaDTO.setStatus( informatica.getStatus() );
        informaticaDTO.setTipoDiComputer( informatica.getTipoDiComputer() );
        informaticaDTO.setProcessore( informatica.getProcessore() );
        informaticaDTO.setRam( informatica.getRam() );
        informaticaDTO.setArchiviazione( informatica.getArchiviazione() );

        return informaticaDTO;
    }

    @Override
    public void updateInformaticaFromDto(InformaticaDTO informaticaDto, Informatica informatica) {
        if ( informaticaDto == null ) {
            return;
        }

        informatica.setNome( informaticaDto.getNome() );
        informatica.setMarca( informaticaDto.getMarca() );
        informatica.setStatus( informaticaDto.getStatus() );
        informatica.setTipoDiComputer( informaticaDto.getTipoDiComputer() );
        informatica.setProcessore( informaticaDto.getProcessore() );
        informatica.setRam( informaticaDto.getRam() );
        informatica.setArchiviazione( informaticaDto.getArchiviazione() );
    }

    protected Dipendente informaticaDTOToDipendente(InformaticaDTO informaticaDTO) {
        if ( informaticaDTO == null ) {
            return null;
        }

        Dipendente dipendente = new Dipendente();

        if ( informaticaDTO.getIdDipendente() != null ) {
            dipendente.setId( informaticaDTO.getIdDipendente() );
        }

        return dipendente;
    }

    private Integer informaticaDipendenteId(Informatica informatica) {
        if ( informatica == null ) {
            return null;
        }
        Dipendente dipendente = informatica.getDipendente();
        if ( dipendente == null ) {
            return null;
        }
        int id = dipendente.getId();
        return id;
    }
}
