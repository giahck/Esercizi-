package it.dispositiviAziendali.pgM5S2G5.payloads;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class DipendenteDto {
    @NotBlank(message = "il username non può essere null o vuoto o solo spazi")
    @Size(min = 4, max = 10, message = "username deve essere tra 2 e 20 caratteri")
    private String username;
    @NotBlank(message = "il nome non può essere null o vuoto o solo spazi")
    @Size(min = 2, max = 20, message = "Nome deve essere tra 2 e 20 caratteri")
    private String nome;
    @NotBlank(message = "il cognome non può essere null o vuoto o solo spazi")
    @Size(min = 2, max = 20, message = "Cognome deve essere tra 2 e 20 caratteri")
    private String cognome;
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "L'email inserita non è valida")
    @NotBlank
    private String email;
    private MultipartFile fotoProfilo;
}
