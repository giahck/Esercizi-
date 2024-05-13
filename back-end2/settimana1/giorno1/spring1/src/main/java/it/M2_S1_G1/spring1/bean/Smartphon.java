package it.M2_S1_G1.spring1.bean;

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
