package it.epidocode.EsercizioU5s2s2.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Error {
    private String messaggio;
    private LocalDateTime dataErrore;
}
