package it.proggettoS1M5.GestionePrenotzioni.service;

import it.proggettoS1M5.GestionePrenotzioni.Repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenootazioneRepository {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    public long getPrenotazioniCountByUsername(String username) {
        return prenotazioneRepository.countPrenotazioniByUsername(username);
    }
}
