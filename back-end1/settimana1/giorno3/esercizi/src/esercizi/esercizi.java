package esercizi;

class Rettangolo{
    float altezza=0;
    float larghezza =0;
    public Rettangolo(float altezza, float larghezza){
        this.altezza=altezza;
        this.larghezza=larghezza;
       this.altezza=altezza;
    }
    public float getArea(){
        return this.altezza*this.larghezza;
    }
    public float getPerimetro(){
        return 2*(this.altezza+this.larghezza);
    }
    public void printRettangolo(){
        System.out.println("Altezza: "+this.altezza);
        System.out.println("Larghezza: "+this.larghezza);
        System.out.println("Area: "+this.getArea());
        System.out.println("Perimetro: "+this.getPerimetro());
    }
}




