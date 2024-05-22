package it.epidocode.lezioneU5s2s2.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudenteDto {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private int aulaId;
}
