package it.dispositiviAziendali.pgM5S2G5.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "L'email inserita non è valida")
    @NotBlank(message = "L'email non può essere vuota")
    private String email;
    @NotBlank(message = "La password non può essere vuota")
    private String Password;
}
