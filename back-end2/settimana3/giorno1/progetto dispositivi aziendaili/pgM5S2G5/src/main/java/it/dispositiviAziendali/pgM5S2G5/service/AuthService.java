package it.dispositiviAziendali.pgM5S2G5.service;

import it.dispositiviAziendali.pgM5S2G5.model.Dipendente;
import it.dispositiviAziendali.pgM5S2G5.payloads.LoginDto;
import it.dispositiviAziendali.pgM5S2G5.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private JwtTool jwtTool;

    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticateDipendenteandGenerateToken(LoginDto loginDto) {
        Optional<Dipendente> optionalDipendente = dipendenteService.getDipendenteByEmail(loginDto.getEmail());
        if (optionalDipendente.isPresent()) {
            Dipendente dipendente = optionalDipendente.get();

            if (passwordEncoder.matches(loginDto.getPassword(), dipendente.getPassword())) {

            if (dipendente.getPassword().equals(loginDto.getPassword())) {

                return jwtTool.createToken(dipendente);
            } else {
                throw new RuntimeException("Password errata");
            }
        } else {
            throw new RuntimeException("Dipendente non trovato");
        }
    }
}
