package it.epicode.u5w1d4esercizio.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Drink {
    private String nome;
    private int calorie;
    private double prezzo;


    @Override
    public String toString() {
        return "Drink{" +
                "nome='" + nome + '\'' +
                ", calorie=" + calorie +
                ", prezzo=" + prezzo +
                '}';
    }


}
