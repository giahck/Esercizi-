package it.epicode.esercizio.bean;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component

public class Tavolo {
    private int id;
    private int numeroTavolo;
    private int numeroCopertiMax;
    private boolean occupato;
    private Comanda conto;

}
