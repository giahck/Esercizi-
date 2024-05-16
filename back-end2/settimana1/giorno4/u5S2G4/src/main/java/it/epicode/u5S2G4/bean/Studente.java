package it.epicode.u5S2G4.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Studente {
    private String nome;
    private String cognome;
    private String indirizzo;

    @OneToMany
    private List<Dispositivo> dispositivi=new ArrayList<>();

}
