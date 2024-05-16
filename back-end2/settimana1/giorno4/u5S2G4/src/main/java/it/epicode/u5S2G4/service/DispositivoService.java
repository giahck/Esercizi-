package it.epicode.u5S2G4.service;

import it.epicode.u5S2G4.bean.Computer;
import it.epicode.u5S2G4.bean.Dispositivo;
import it.epicode.u5S2G4.repository.DispositivoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
public class DispositivoService {
    @Autowired
    private DispositivoRepository dispositivoRepository;

    public void inserisciDispositivo(Dispositivo dispositivo) {
        dispositivoRepository.save(dispositivo);
    }
    public Dispositivo getDispositivo(int id) {
        return dispositivoRepository.findById(id).get();
    }
    public List<Dispositivo> getDispositivi() {
        return dispositivoRepository.findAll();
    }
    public void eliminaDispositivo(int id) {
        dispositivoRepository.deleteById(id);
    }
    public  List<Computer> findByRamLessThannome() {
        return dispositivoRepository.findByRamLessThan(24);
    }
   /* @Transactional
    public List<Dispositivo> getDispositiviOrderByNome() {
        return dispositivoRepository.findAllByOrderByNomeAsc();
    }*/
}
