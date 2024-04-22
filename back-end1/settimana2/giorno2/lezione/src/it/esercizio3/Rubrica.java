package it.esercizio3;

import java.util.HashMap;
import java.util.Map;

public class Rubrica {
    String nomeProprietario;
    Map<String, Integer> rubrica;
    public  Rubrica(String Nome){
        this.rubrica = new HashMap<>();
        this.nomeProprietario = Nome;
    }
    public void add(String nome, Integer numero){
        rubrica.put(nome, numero);
    }
    public void remove(String nome){
        rubrica.remove(nome);
    }
    public void searchName(String nome){
        System.out.println(rubrica.get(nome));
    }
    public void searchNumber(Integer numero){
        for (Integer number:rubrica.values()){
            if(number.equals(numero)){
                System.out.println("Numero: "+number);
            }
        }
    }
    public void print(){
        for (Map.Entry<String, Integer> entry : rubrica.entrySet()) {
            System.out.println("Nome: " + entry.getKey() + " Numero: " + entry.getValue());
        }
    }
}
