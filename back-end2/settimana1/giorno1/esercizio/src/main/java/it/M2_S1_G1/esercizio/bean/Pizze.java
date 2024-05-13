package it.M2_S1_G1.esercizio.bean;

import it.M2_S1_G1.esercizio.EnumS.EnumFormatoPizza;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Pizze {
    private String nome;
    private EnumFormatoPizza formato;
    private List<Topping> toppings;
}
