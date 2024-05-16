package it.epicode.u5S2G4.bean;


import it.epicode.u5S2G4.bean.Dispositivo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@Entity
public class Computer extends Dispositivo {
    private int monitor;
    private String cpu;
    private int ram;


}
