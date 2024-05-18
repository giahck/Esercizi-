package it.proggettoS1M5.GestionePrenotzioni.service;

import it.proggettoS1M5.GestionePrenotzioni.Enum.EnumPostazione;
import it.proggettoS1M5.GestionePrenotzioni.Repository.PostazioneRepository;
import it.proggettoS1M5.GestionePrenotzioni.bean.Postazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> getPostazioniByCittaAndTipo(String citta, EnumPostazione tipo) {
        return postazioneRepository.findPostazioniByCittaAndTipo(citta, tipo);
    }


}
