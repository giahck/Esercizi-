package it.epicode.esercizio.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Antipasti {
    private String nome;
    private int calorie;
    private double prezzo;
}
