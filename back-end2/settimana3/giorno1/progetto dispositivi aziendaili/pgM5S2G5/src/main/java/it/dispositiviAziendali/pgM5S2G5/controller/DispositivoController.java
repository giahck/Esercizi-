package it.dispositiviAziendali.pgM5S2G5.controller;


import it.dispositiviAziendali.pgM5S2G5.model.Dispositivo;
import it.dispositiviAziendali.pgM5S2G5.payloads.DispositivoDto;
import it.dispositiviAziendali.pgM5S2G5.payloads.sottoclassdispositivo.AudioVideoDTO;
import it.dispositiviAziendali.pgM5S2G5.payloads.sottoclassdispositivo.InformaticaDTO;
import it.dispositiviAziendali.pgM5S2G5.service.DispositivoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/dispositivo")
public class DispositivoController {
    @Autowired
    private DispositivoService dispositivoService;

    @PostMapping("")
    public ResponseEntity<String> saveDispositivo(@Valid @RequestBody DispositivoDto dispositivoDto, BindingResult validation) {
       if (validation.hasErrors()) {
            return ResponseEntity.badRequest().body("Richiesta non valida: " + validation.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("", (s1, s2) -> s1 + "\n" + s2));
        }
        try {
            Dispositivo dispositivo = (Dispositivo) dispositivoService.mapDtoToEntity(dispositivoDto);
            String result = dispositivoService.saveDispositivo(dispositivo);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("")
    public List<Dispositivo> getDispositivi() {
        return dispositivoService.getDispositivi();
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('AUDIOVIDEO') or hasAuthority('INFORMATICA')")
    public Dispositivo getDispositivoById(@PathVariable UUID id) {
        return dispositivoService.getDispositivoById(id);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('AUDIOVIDEO') or hasAuthority('INFORMATICA')")
    public ResponseEntity<String> updateDispositivo(@PathVariable UUID id, @Valid @RequestBody DispositivoDto dispositivoDto, BindingResult validation) {
        if (validation.hasErrors()) {
            return ResponseEntity.badRequest().body(validation.getAllErrors().toString());
        }

        String result = dispositivoService.updateDispositivo(id, dispositivoDto);
        if (result.equals("Dispositivo aggiornato correttamente")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteDispositivo(@PathVariable UUID id) {

        try {
            dispositivoService.deleteDispositivo(id);
            return ResponseEntity.ok("Dispositivo eliminato correttamente");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
