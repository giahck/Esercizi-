package it.epicode.priticaEs.bean;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class VoceDiMenu {
    @Id
    @GeneratedValue
    private int id;
    private int calorie;
    private double prezzo;
}
