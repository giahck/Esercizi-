package it.M2_S1_G1.esercizio.bean;

import it.M2_S1_G1.esercizio.EnumS.EnumIngredienti;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Topping {
    private EnumIngredienti ingredienti;
    private double prezzo;
}
