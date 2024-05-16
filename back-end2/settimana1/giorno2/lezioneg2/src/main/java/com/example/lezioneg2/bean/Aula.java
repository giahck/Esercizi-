package com.example.lezioneg2.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Data

@Component("aula1")
@PropertySource("application.properties")
public class Aula {
    @Value("${aula.nome}")//legge il valore da application.properties
    private String nome;
    private List<Studente> studenti;
    @Autowired
    public Aula( List<Studente> studenti) {
        this.studenti = studenti;
    }
}
