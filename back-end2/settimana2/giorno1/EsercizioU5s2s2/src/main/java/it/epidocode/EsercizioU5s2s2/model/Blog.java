package it.epidocode.EsercizioU5s2s2.model;

import lombok.Data;

import java.time.LocalTime;

@Data
public class Blog {
    private static int count;
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private LocalTime tempoDiLettura;

    public Blog( String categoria, String titolo, String cover, String contenuto, LocalTime tempoDiLettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = cover;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
        this.id=count++;
    }
}
