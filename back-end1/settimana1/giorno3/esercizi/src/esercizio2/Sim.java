package esercizio2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Sim {
    public ArrayList<String> listCall;
    int numTel;
    double credito;
    public Sim(int numTel){
        this.numTel=numTel;
        this.credito=0;
        this.listCall=new ArrayList<>();
    }
    public void ricarica(double ricarica){
        this.credito+=ricarica;
    }

    public void stampaChiamate(){
        for(String s: this.listCall){
            System.out.println(s);
        }
    }


}
