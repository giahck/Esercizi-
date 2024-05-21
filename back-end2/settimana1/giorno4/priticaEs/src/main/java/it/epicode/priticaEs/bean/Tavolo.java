package it.epicode.priticaEs.bean;

import it.epicode.priticaEs.enumeration.Stato;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class Tavolo {
    private int numero;
    private int maxCoperti;
    private Stato stato;
    private double coperto;

}
