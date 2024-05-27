package it.epidocode.lezioneU5s2s2.service;

import com.cloudinary.Cloudinary;
import it.epidocode.lezioneU5s2s2.Dto.StudenteDto;
import it.epidocode.lezioneU5s2s2.exeption.StudenteNonTrovatoException;
import it.epidocode.lezioneU5s2s2.model.Aula;
import it.epidocode.lezioneU5s2s2.model.Studente;
import it.epidocode.lezioneU5s2s2.repository.AulaRepository;
import it.epidocode.lezioneU5s2s2.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudenteService {
    @Autowired
    private StudenteRepository studenteRepository;
    @Autowired
    private Cloudinary cloudinaryUploader;
    @Autowired
    private AulaRepository aulaRepository;
    @Autowired
    private JavaMailSenderImpl javaMailSender;
    public String saveStudente(StudenteDto studenteDto) throws StudenteNonTrovatoException {
        Studente studente = new Studente();
        studente.setNome(studenteDto.getNome());
        studente.setCognome(studenteDto.getCognome());
        studente.setDataNascita(studenteDto.getDataNascita());
        studente.setEmail(studenteDto.getEmail());

        Optional<Aula> aulaOptional = aulaRepository.findById(studenteDto.getAulaId());
        if (aulaOptional.isPresent()) {
            Aula aula = aulaOptional.get();
            studente.setAula(aula);
            studenteRepository.save(studente);
            sendMail(studenteDto.getEmail());
            return "Studente con matricola " + studente.getMatricola() + " salvato corretamente";
        } else
            throw new StudenteNonTrovatoException("Aula con id=" + studenteDto.getAulaId() + " non trovata");

    }

    public Page<Studente> getStudente(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return studenteRepository.findAll(pageable);
    }

    public Optional<Studente> getStudenteById(int matricola) {
        return studenteRepository.findById(matricola);
    }

    public Studente updateStudente(int matricola, StudenteDto studenteDto) throws StudenteNonTrovatoException {
        Optional<Studente> studenteOptional = getStudenteById(matricola);

        if (studenteOptional.isPresent()) {
            Studente studente = studenteOptional.get();
            studente.setNome(studenteDto.getNome());
            studente.setCognome(studenteDto.getCognome());
            studente.setDataNascita(studenteDto.getDataNascita());
            studente.setEmail(studenteDto.getEmail());
            Optional<Aula> aulaOptional = aulaRepository.findById(studenteDto.getAulaId());
            if (aulaOptional.isPresent()) {
                Aula aula = aulaOptional.get();
                studente.setAula(aula);
                studenteRepository.save(studente);
                return studente;
            } else
                throw new StudenteNonTrovatoException("Aula con id=" + studenteDto.getAulaId() + " non trovata");
        } else throw new StudenteNonTrovatoException("Studente con matricola=" + matricola + " non trovato");
    }

    public String deleteStudente(int matricola) throws StudenteNonTrovatoException {
        Optional<Studente> optionalStudente = studenteRepository.findById(matricola);
        if (optionalStudente.isPresent()) {
            studenteRepository.delete(optionalStudente.get());
            return "Studente con matricola=" + matricola + " cancellato con successo";
        } else throw new StudenteNonTrovatoException("Studente con matricola=" + matricola + " non trovato");

    }

    public String patchFotoStudente(int matricola, MultipartFile foto) throws IOException, StudenteNonTrovatoException {
        Optional<Studente> studenteOptional = studenteRepository.findById(matricola);
        if (studenteOptional.isPresent()) {
            String url = (String) cloudinaryUploader.uploader().upload(foto.getBytes(), Collections.emptyMap()).get("url");
            Studente studente = studenteOptional.get();
            studente.setFoto(url);
            studenteRepository.save(studente);
            return "Foto studente con matricola=" + matricola + " caricata con successo";
        }else
            throw new StudenteNonTrovatoException("Studente con matricola="+matricola+" non trovato");
    }

    private void sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registrazione Servizio rest");
        message.setText("Messaggio di benvenuto al servizio ");

        javaMailSender.send(message);
    }
}
