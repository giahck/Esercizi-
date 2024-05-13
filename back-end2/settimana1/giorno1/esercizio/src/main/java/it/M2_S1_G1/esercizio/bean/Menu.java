package it.M2_S1_G1.esercizio.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Menu {
    private List<Pizze> pizze;
    private List<Drink> bevande;
}
