package it.epidocode.EsercizioU5s2s2.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class BlogDto {
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private LocalTime tempoDiLettura;
    private int autoreId;
}
