package it.epicode.u5S2G4.bean;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@Entity
public class Smartphone extends Dispositivo{
    private int schermo;

}
