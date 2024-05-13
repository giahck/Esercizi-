package it.M2_S1_G1.spring1.bean;

import lombok.Data;

import java.util.List;

@Data
public class Aula {
    private String nome;
    private List<Studente> studenti;
}
