package it.epidocode.lezioneU5s2s2.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AulaDto {
    @NotNull
    @Size(min = 3, max = 20, message = "Nome deve essere tra 3 e 20 caratteri")
    private String nome;
    @NotNull
    @Min(0)
    @Min(3)
    private int piano;
}
