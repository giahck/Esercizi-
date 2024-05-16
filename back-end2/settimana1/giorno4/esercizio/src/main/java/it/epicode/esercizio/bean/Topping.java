package it.epicode.esercizio.bean;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@AllArgsConstructor
@ToString
@Entity
public class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int calorie;
    public Topping(String nome, int calorie) {
        this.nome = nome;
        this.calorie = calorie;
    }
}
