package it.M2_S1_G1.spring1.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)//per stampare anche i campi della superclasse come override super toString
public class Computer extends Dispositivo{
    private int monitor;
    private int ram;
    private String cpu;

}
