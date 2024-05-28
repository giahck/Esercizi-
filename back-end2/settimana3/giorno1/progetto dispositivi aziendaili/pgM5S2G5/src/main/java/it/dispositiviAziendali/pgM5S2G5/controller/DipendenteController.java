package it.dispositiviAziendali.pgM5S2G5.controller;

import it.dispositiviAziendali.pgM5S2G5.model.Dipendente;
import it.dispositiviAziendali.pgM5S2G5.payloads.DipendenteDto;
import it.dispositiviAziendali.pgM5S2G5.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {
    @Autowired
    private DipendenteService dipendenteService;

    /*@PostMapping(value = "", consumes = "multipart/form-data")
    public String saveDipendente(@RequestPart("dipendente") @Validated DipendenteDto dipendenteDto,
                                 @RequestPart(value = "fotoProfilo", required = false) MultipartFile fotoProfilo,
                                 BindingResult validation) throws IOException {

        if (validation.hasErrors()) {
            throw new RuntimeException("Richiesta non valida: " + validation.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("", (s1, s2) -> s1 + "\n" + s2));
        }

        dipendenteDto.setFotoProfilo(fotoProfilo);
        return dipendenteService.saveDipendente(dipendenteDto);
    }*/

    /*@PostMapping(value = "", consumes = "multipart/form-data")
    public String saveDipendente(@ModelAttribute @Validated DipendenteDto dipendenteDto, BindingResult validation) throws IOException {
        if (validation.hasErrors()) {
            throw new RuntimeException("Richiesta non valida: " + validation.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("", (s1, s2) -> s1 + "\n" + s2));
        }
        return dipendenteService.saveDipendente(dipendenteDto);
    }*/

    /*@PostMapping("")

    @PostMapping("")

    public String saveDipendente(@RequestBody @Validated DipendenteDto dipendenteDto, BindingResult validation) throws IOException {
        if (validation.hasErrors()) {
            throw new RuntimeException("Richiesta non valida: " + validation.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("", (s1, s2) -> s1 + "\n" + s2));
        }
        return dipendenteService.saveDipendente(dipendenteDto);

    }*/
    @GetMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")

    }
    @GetMapping("")

    public Page<Dipendente> getDipendenti(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size,
                                             @RequestParam(defaultValue = "id") String sortBy) {
        return dipendenteService.getDipendenti(page, size, sortBy);
    }

    @GetMapping("/{id}")
    public Dipendente getDipendenteById(@PathVariable int id) {
        return dipendenteService.getDipendenteById(id);
    }

    @PutMapping("/{id}")
    public Optional<Dipendente> updateDipendente(@PathVariable int id, @RequestBody @Validated DipendenteDto dipendenteDto, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new RuntimeException("Richiesta non valida: " + validation.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("", (s1, s2) -> s1 + "\n" + s2));
        }
        return dipendenteService.updateDipendente(id, dipendenteDto);
    }

    @PreAuthorize("hasAuthority('ADMIN')")

    @DeleteMapping("/{id}")
    public String deleteDipendente(@PathVariable int id) {
        return dipendenteService.deleteDipendente(id);
    }
    @PatchMapping("/{id}/fotoProfilo")
    public String uploadFotoProfilo(@RequestParam("fotoProfilo") MultipartFile file, @PathVariable int id) throws IOException {
        return dipendenteService.uploadFotoProfilo(id, file);
    }
}