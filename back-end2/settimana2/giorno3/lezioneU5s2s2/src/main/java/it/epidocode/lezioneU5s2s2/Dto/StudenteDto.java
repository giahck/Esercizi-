package it.epidocode.lezioneU5s2s2.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudenteDto {
    @NotNull
    @Size(min = 3, max = 20, message = "Nome deve essere tra 3 e 20 caratteri")
    private String nome;
    @NotNull
    @Size(min = 3, max = 20, message = "Cognome deve essere tra 3 e 20 caratteri")
    private String cognome;
    private LocalDate dataNascita;

    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "L'email inserita non è valida")
    @NotNull
    private String email;

    @NotNull
    private int aulaId;

}
