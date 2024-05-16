package it.M2_S1_G1.esercizio.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
@AllArgsConstructor
//@Component("menu")//indica che la classe è un bean
public class Menu {
    private List<Pizze> pizze;
    private List<Drink> bevande;
}
