package it.M2_S1_G1.esercizio.bean;

import it.M2_S1_G1.esercizio.EnumS.EnumFormatoPizza;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Pizze {
    private final int BASE_PRICE = 5;
    private String nome;
    private EnumFormatoPizza formato;
    private List<Topping> toppings;
}
