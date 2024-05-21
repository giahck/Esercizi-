package it.epicode.u5w1d4esercizio.bean;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Tavolo {
    private int numeroTavolo;
    private int numeroCopertiMax;
    private boolean occupato;

    private Comanda conto;

}
