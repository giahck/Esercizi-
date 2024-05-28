package it.dispositiviAziendali.pgM5S2G5.service;

import it.dispositiviAziendali.pgM5S2G5.mapper.MapperContainer;
import it.dispositiviAziendali.pgM5S2G5.model.Dispositivo;
import it.dispositiviAziendali.pgM5S2G5.model.dispositivi.AudioVideo;
import it.dispositiviAziendali.pgM5S2G5.model.dispositivi.Domotica;
import it.dispositiviAziendali.pgM5S2G5.model.dispositivi.Informatica;
import it.dispositiviAziendali.pgM5S2G5.payloads.DispositivoDto;
import it.dispositiviAziendali.pgM5S2G5.payloads.sottoclassdispositivo.AudioVideoDTO;
import it.dispositiviAziendali.pgM5S2G5.payloads.sottoclassdispositivo.DomoticaDTO;
import it.dispositiviAziendali.pgM5S2G5.payloads.sottoclassdispositivo.InformaticaDTO;
import it.dispositiviAziendali.pgM5S2G5.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public String saveDispositivo(Dispositivo dispositivo) {
        dispositivoRepository.save(dispositivo);
        return "Dispositivo salvato correttamente";
    }

    public Dispositivo mapDtoToEntity(DispositivoDto dispositivoDto) {
        if (dispositivoDto instanceof DomoticaDTO) {
            return MapperContainer.DomoticaMapper.INSTANCE.toDomotica((DomoticaDTO) dispositivoDto);
        } else if (dispositivoDto instanceof AudioVideoDTO) {
            return MapperContainer.AudioVideoMapper.INSTANCE.toAudioVideo((AudioVideoDTO) dispositivoDto);
        } else if (dispositivoDto instanceof InformaticaDTO) {
            return MapperContainer.InformaticaMapper.INSTANCE.toInformatica((InformaticaDTO) dispositivoDto);
        } else {
            throw new IllegalArgumentException("Tipo di DTO non supportato");
        }
    }
    public List<Dispositivo> getDispositivi() {
        return dispositivoRepository.findAll();
    }
    public Dispositivo getDispositivoById(UUID id) {
        return dispositivoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dispositivo non trovato con id = " + id));
    }
    public String updateDispositivo(UUID id, DispositivoDto dispositivoDto) {
        Optional<Dispositivo> optionalDispositivo = Optional.ofNullable(getDispositivoById(id));
        if (optionalDispositivo.isPresent()) {
            Dispositivo dispositivo = optionalDispositivo.get();

            if (dispositivoDto instanceof DomoticaDTO) {

                MapperContainer.DomoticaMapper.INSTANCE.updateDomoticaFromDto((DomoticaDTO) dispositivoDto, (Domotica) dispositivo);
            } else if (dispositivoDto instanceof AudioVideoDTO) {
                MapperContainer.AudioVideoMapper.INSTANCE.updateAudioVideoFromDto((AudioVideoDTO) dispositivoDto, (AudioVideo) dispositivo);
            } else if (dispositivoDto instanceof InformaticaDTO) {
                MapperContainer.InformaticaMapper.INSTANCE.updateInformaticaFromDto((InformaticaDTO) dispositivoDto, (Informatica) dispositivo);
            } else {
                throw new IllegalArgumentException("Tipo di DTO non supportato");
            }

            dispositivoRepository.save(dispositivo);
            return "Dispositivo aggiornato correttamente";
        } else {
            return "Dispositivo non trovato";
        }
    }
    public void deleteDispositivo(UUID id) {
        Dispositivo dispositivo = getDispositivoById(id);
        dispositivoRepository.delete(dispositivo);
    }
}