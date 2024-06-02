package Eventi.progettoEventi.payloads;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDto {
    @NotBlank(message = "Il nome non può essere vuoto o mancante o composto da soli spazi")
    @Size(min = 3, message = "Il nome deve essere lungo almeno 3 caratteri")
    private String nome;

    @NotBlank(message = "Il cognome non può essere vuoto o mancante o composto da soli spazi")
    @Size(min = 3, message = "Il cognome deve essere lungo almeno 3 caratteri")
    private String cognome;

    @Email(message = "Formato email non valido")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Formato email non valido")
    @NotBlank(message = "L'email non può essere vuota o mancante o composta da soli spazi")
    private String email;

    @NotBlank(message = "La password non può essere vuota o mancante o composta da soli spazi")
    private String password;
}
