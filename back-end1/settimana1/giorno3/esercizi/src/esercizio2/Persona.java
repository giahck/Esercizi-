package esercizio2;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    String nome;
    int eta;
    String sesso;
    public final List<Sim> sim;//magari una persona a anche più sim
    public Persona(String nome, int eta, String sesso) {
        this.nome = nome;
        this.eta = eta;
        this.sesso = sesso;
        this.sim=new ArrayList<Sim>();
    }
    public void stampaSim(){
        System.out.println("Le sim di "+this.nome+" eta "+this.eta+" sesso "+this.sesso+" sono:");
        for(Sim s: this.sim){
            System.out.println("Num:"+s.numTel+" Credito:"+s.credito);
        }
    }
    public void ricaricaSim(double ricarica, Sim s){
       s.credito+=ricarica;
    }
    public void chiama(Sim s, double durata){
        if(s.credito>0){
            s.credito-=durata;
            s.listCall.add("chiameta con durata: "+durata +"con credito rimanente: "+s.credito);
        }
        s.stampaChiamate();

    }
}
