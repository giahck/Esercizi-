package esercizi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

enum Dipartimento {
    PRODUZIONE, AMMINISTRAZIONE, VENDITE;
}

abstract class Dipendente implements Turno{
    private LocalDateTime inizioCheckIn;
    private LocalDateTime fineCheckIn;
    protected static final double stipendioBase = 1200;
    private String matricola;
    private double stipendio;
    private Dipartimento dipartimento;
    public Dipendente(String matricola, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.dipartimento = dipartimento;
        this.stipendio = stipendioBase;
    }

    public String getMatricola() {
        return matricola;
    }
    public double getStipendio() {
        return stipendio;
    }
    public void setStipendi(double stipendio){
        if (stipendioBase<=stipendio)//se é minore allora non setti nulla
            this.stipendio=stipendio;
    }
    public Dipartimento getDipartimento() {
        return dipartimento;
    }
    public void setDipartimento(Dipartimento dipartimento){
        this.dipartimento = dipartimento;
    }
    public void stampaDatiDipendente() {
        System.out.println("Matricola: " + this.matricola);
        System.out.println("Stipendio: " + this.stipendio);
        System.out.println("Dipartimento: " + this.dipartimento);
        System.out.println("Orario: "+getOrario().toString());
        System.out.println();

    }
    public abstract void calcolateSalary();
    @Override
    public void checkIn() {
        this.inizioCheckIn = LocalDateTime.now();
    }
    @Override
    public void checkOut() {
        this.fineCheckIn = LocalDateTime.now();
    }
    @Override
    public String  getOrario() {
        return "Hai iniziato alle: "+this.inizioCheckIn.toString()+"hai finito alle: "+this.fineCheckIn.toString();
    }
}


class DipententeFullTime extends  Dipendente{
    private static final int OREfULL=40;
    private static final int SettfULL=4;

    public DipententeFullTime(String matricola,Dipartimento dipartimento){
        super(matricola,dipartimento);
    }
    @Override
    public void calcolateSalary(){
        if (getDipartimento()==Dipartimento.PRODUZIONE){
            double stipendio=OREfULL*SettfULL*20;//se sei uno che lavora in produzione allora 10 a ora
            setStipendi(stipendio);
        }
        if (getDipartimento()==Dipartimento.VENDITE){
            double stipendio=OREfULL*SettfULL*17;//se sei uno che lavora in Vnedite allora 8 a ora
            setStipendi(stipendio);
        }
        if (getDipartimento()==Dipartimento.AMMINISTRAZIONE){
            double stipendio=OREfULL*SettfULL*15;//se sei uno che lavora in Amministrazione allora 7.5 a ora
            setStipendi(stipendio);
        }
    }


}



class DipendentePartTime extends Dipendente{
    double ore;//ore lavorate a settimana//positivo farlo in un arreylist in quanto magari in una settima inserisco solo un tot
    int settimane;//settimane lavorate in un mese
    public DipendentePartTime(String matricola,Dipartimento dipartimento,double ore,int settimane){
        super(matricola,dipartimento);
        this.ore=ore;
        this.settimane=settimane;
    }
    @Override
    public void calcolateSalary(){
        if (getDipartimento()==Dipartimento.PRODUZIONE){
            double stipendio=ore*settimane*28;//28 euro a ora in quanto sara esterno
            setStipendi(stipendio);
        }if (getDipartimento()==Dipartimento.VENDITE){
            double stipendio=ore*settimane*26;//26 euro a ora in quanto sara esterno
            setStipendi(stipendio);
        }if (getDipartimento()==Dipartimento.AMMINISTRAZIONE){
            double stipendio=ore*settimane*29;//28 euro a ora in quanto sara esterno
            setStipendi(stipendio);
        }

    }
}
class Dirigente extends  Dipendente{
    public Dirigente(String matricola,Dipartimento dipartimento){
        super(matricola,dipartimento);
    }
    @Override
    public void calcolateSalary(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisciti lo stipendio:");
        setStipendi(sc.nextDouble());
}
}