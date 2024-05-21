package it.epicode.priticaEs.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Bevanda extends VoceDiMenu{
    private int ml;
    private String nome;
    private int gradoAlcohol;
}
