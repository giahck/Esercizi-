package it.dispositiviAziendali.pgM5S2G5.controller;

import it.dispositiviAziendali.pgM5S2G5.payloads.DipendenteDto;
import it.dispositiviAziendali.pgM5S2G5.payloads.LoginDto;
import it.dispositiviAziendali.pgM5S2G5.service.AuthService;
import it.dispositiviAziendali.pgM5S2G5.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping("/auth/register")
    public String registerDipendente(@RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException("Richiesta non valida: " + bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("", (s1, s2) -> s1 + "\n" + s2));
        }

        return dipendenteService.saveDipendente(dipendenteDto);
    }
    @PostMapping("/auth/login")
    public String loginDipendente(@RequestBody @Validated LoginDto loginDto, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException("Richiesta non valida: " + bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("", (s1, s2) -> s1 + "\n" + s2));
        }
        return authService.authenticateDipendenteandGenerateToken(loginDto);
    }
}
