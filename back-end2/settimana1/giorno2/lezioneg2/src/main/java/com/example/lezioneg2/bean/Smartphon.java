package com.example.lezioneg2.bean;

import lombok.Data;

@Data
public class Smartphon extends Dispositivo{
    private int schermo;
    private String sistemaOperativo;
    @Override
    public String toString() {
        return super.toString()+"Smartphon{" +
                "schermo=" + schermo +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                '}';
    }
}
