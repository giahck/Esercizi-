package it.epicode.esercizio.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@ToString
public class Menu {

private List<Drink> bevande;
private List<Antipasti> antipasti;
private List<Pizze> pizze;
private List<Topping> topping;


}

