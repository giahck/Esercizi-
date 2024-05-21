package it.epicode.priticaEs.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Ingrediente extends VoceDiMenu{
    private String nome;
    @ManyToMany(mappedBy = "ingredienti",fetch = FetchType.EAGER)
    private List<Pizza> pizze;

    @Override
    public String toString() {
        return  "Ingrediente{" +
                super.toString() +
                "nome='" + nome + '\'' +
                '}';
    }
}
