package it.epidocode.EsercizioU5s2s2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalTime;

@Data
public class BlogDto {
    @NotBlank
    @Size(min = 3, max = 20, message = "Nome deve essere tra 3 e 20 caratteri")
    private String categoria;
    @NotBlank
    private String titolo;
    @Pattern(regexp = "^(http(s)?://)?([\\w-]+\\.)+[\\w-]+(/[\\w- ;,./?%&=]*)?$", message = "Cover must be a valid URL")
    private String cover;
    @NotNull(message = "Il contenuto non può essere vuoto") // non puo essere vuoto
    @Size(max = 30, message = "Il contenuto deve avere massimo 30 caratteri")
    private String contenuto;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$", message = "TempoDiLettura must be a valid time in the format HH:mm:ss")
    private LocalTime tempoDiLettura;
    @NotNull
    private int autoreId;
}
