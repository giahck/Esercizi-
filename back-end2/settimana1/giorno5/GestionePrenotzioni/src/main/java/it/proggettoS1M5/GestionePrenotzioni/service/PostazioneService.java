package it.proggettoS1M5.GestionePrenotzioni.service;

import it.proggettoS1M5.GestionePrenotzioni.Repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;


}
