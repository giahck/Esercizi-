package it.dispositiviAziendali.pgM5S2G5.service;

import com.cloudinary.Cloudinary;
import it.dispositiviAziendali.pgM5S2G5.model.Dipendente;
import it.dispositiviAziendali.pgM5S2G5.payloads.DipendenteDto;
import it.dispositiviAziendali.pgM5S2G5.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Service
public class DipendenteService {
    @Autowired
    private DipendenteRepository dipendenteRepository;
    @Autowired
    private Cloudinary cloudinary;
    public String saveDipendente(DipendenteDto dipendenteDto) throws IOException {
        Dipendente dipendente = new Dipendente();
        dipendente.setUsername(dipendenteDto.getUsername());
        dipendente.setNome(dipendenteDto.getNome());
        dipendente.setCognome(dipendenteDto.getCognome());
        dipendente.setEmail(dipendenteDto.getEmail());

        MultipartFile fotoProfilo = dipendenteDto.getFotoProfilo();
        if (fotoProfilo != null && !fotoProfilo.isEmpty()) {
            String url = (String) cloudinary.uploader().upload(fotoProfilo.getBytes(), Collections.emptyMap()).get("url");
            dipendente.setFotoProfilo(url);
        }

        dipendenteRepository.save(dipendente);
        return "Dipendente con id=" + dipendente.getId() + " con username " + dipendente.getUsername() + " salvato correttamente";
    }
    public Page<Dipendente> getDipendenti(int page, int size, String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return dipendenteRepository.findAll(pageable);
    }
    public Dipendente getDipendenteById(int id){
        return dipendenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dipendente non trovato con id = " + id));
    }
    public Optional<Dipendente> updateDipendente(int id, DipendenteDto dipendenteDto){
        Optional<Dipendente> dipendenteOptional = Optional.ofNullable(getDipendenteById(id));
        if(dipendenteOptional.isEmpty()){
            throw new RuntimeException("Dipendente non trovato con id = " + id);
        }else {
            Dipendente dipendente = dipendenteOptional.get();
        dipendente.setUsername(dipendenteDto.getUsername());
        dipendente.setNome(dipendenteDto.getNome());
        dipendente.setCognome(dipendenteDto.getCognome());
        dipendente.setEmail(dipendenteDto.getEmail());
           /* MultipartFile fotoProfilo = dipendenteDto.getFotoProfilo();
            if (fotoProfilo != null && !fotoProfilo.isEmpty()) {
                String url = (String) cloudinary.uploader().upload(fotoProfilo.getBytes(), Collections.emptyMap()).get("url");
                dipendente.setFotoprofilo(url);
            }*/
        return Optional.of(dipendenteRepository.save(dipendente));
        }
    }
    public String deleteDipendente(int id){
        Dipendente dipendente = getDipendenteById(id);
        if (dipendente == null) {
            throw new RuntimeException("Dipendente non trovato con id = " + id);
        }
        else {
            dipendenteRepository.delete(dipendente);
            return "Dipendente eliminato con successo";
        }
    }
    public String uploadFotoProfilo(int id, MultipartFile file) throws IOException {
        Dipendente dipendente = getDipendenteById(id);
        if (dipendente == null) {
            throw new RuntimeException("Dipendente non trovato con id = " + id);
        }
        else {
            String url = (String) cloudinary.uploader().upload(file.getBytes(), Collections.emptyMap()).get("url");
            dipendente.setFotoProfilo(url);
            dipendenteRepository.save(dipendente);
            return "Foto profilo caricata con successo";
        }
    }

}
