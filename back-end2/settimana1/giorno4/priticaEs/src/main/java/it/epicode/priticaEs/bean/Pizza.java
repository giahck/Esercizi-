package it.epicode.priticaEs.bean;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@Entity
public class Pizza extends VoceDiMenu{
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pizza_ingredienti",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
    private List<Ingrediente> ingredienti;

    private boolean xl;
}
