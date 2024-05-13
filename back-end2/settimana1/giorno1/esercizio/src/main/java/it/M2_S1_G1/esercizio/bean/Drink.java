package it.M2_S1_G1.esercizio.bean;

import it.M2_S1_G1.esercizio.EnumS.EnumBevande;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drink {
    public EnumBevande bevande;
    public double prezzo;
}
