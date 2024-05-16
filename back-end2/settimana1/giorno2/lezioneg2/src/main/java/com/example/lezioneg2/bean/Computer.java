package com.example.lezioneg2.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@ToString(callSuper = true)//per stampare anche i campi della superclasse come override super toString

public class Computer extends Dispositivo{
    private int monitor;
    private int ram;
    private String cpu;

}
