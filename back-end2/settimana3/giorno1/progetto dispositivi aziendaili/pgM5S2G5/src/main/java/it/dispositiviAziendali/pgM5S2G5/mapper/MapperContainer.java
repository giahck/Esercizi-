package it.dispositiviAziendali.pgM5S2G5.mapper;

import it.dispositiviAziendali.pgM5S2G5.model.dispositivi.AudioVideo;
import it.dispositiviAziendali.pgM5S2G5.model.dispositivi.Domotica;
import it.dispositiviAziendali.pgM5S2G5.model.dispositivi.Informatica;
import it.dispositiviAziendali.pgM5S2G5.payloads.sottoclassdispositivo.AudioVideoDTO;
import it.dispositiviAziendali.pgM5S2G5.payloads.sottoclassdispositivo.DomoticaDTO;
import it.dispositiviAziendali.pgM5S2G5.payloads.sottoclassdispositivo.InformaticaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

public class MapperContainer {

    @Mapper(componentModel = "spring")
    public interface DomoticaMapper {
        DomoticaMapper INSTANCE = Mappers.getMapper(DomoticaMapper.class);

        @Mapping(source = "idDipendente", target = "dipendente.id")
        Domotica toDomotica(DomoticaDTO domoticaDto);

        @Mapping(source = "dipendente.id", target = "idDipendente")
        DomoticaDTO toDomoticaDTO(Domotica domotica);

        void updateDomoticaFromDto(DomoticaDTO domoticaDto, @MappingTarget Domotica domotica);
    }

    @Mapper(componentModel = "spring")
    public interface AudioVideoMapper {
        AudioVideoMapper INSTANCE = Mappers.getMapper(AudioVideoMapper.class);

        @Mapping(source = "idDipendente", target = "dipendente.id")
        AudioVideo toAudioVideo(AudioVideoDTO audioVideoDto);

        @Mapping(source = "dipendente.id", target = "idDipendente")
        AudioVideoDTO toAudioVideoDTO(AudioVideo audioVideo);

        void updateAudioVideoFromDto(AudioVideoDTO audioVideoDto, @MappingTarget AudioVideo audioVideo);
    }

    @Mapper(componentModel = "spring")
    public interface InformaticaMapper {
        InformaticaMapper INSTANCE = Mappers.getMapper(InformaticaMapper.class);

        @Mapping(source = "idDipendente", target = "dipendente.id")
        Informatica toInformatica(InformaticaDTO informaticaDto);

        @Mapping(source = "dipendente.id", target = "idDipendente")
        InformaticaDTO toInformaticaDTO(Informatica informatica);

        void updateInformaticaFromDto(InformaticaDTO informaticaDto, @MappingTarget Informatica informatica);
    }
}