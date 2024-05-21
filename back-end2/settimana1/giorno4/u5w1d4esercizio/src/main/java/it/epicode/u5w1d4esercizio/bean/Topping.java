package it.epicode.u5w1d4esercizio.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@AllArgsConstructor
@ToString
public class Topping {
    private String nome;
    private int calorie;
}
