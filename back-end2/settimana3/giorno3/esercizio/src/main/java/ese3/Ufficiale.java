package ese3;

public abstract class Ufficiale {
    private String funzione;
    private double stipendio;
    private Ufficiale superiore;

    public void controlloStipendio(double cifra){
        if(cifra <= this.stipendio)
            System.out.println("Lo stipendio di " + this.getClass().getSimpleName() + " è maggiore di " + cifra);
        if(superiore != null) {
            this.superiore.controlloStipendio(cifra);
        } else {
            System.out.println("Non ci sono altri ufficiali di grado superiore");
        }
    }

    public String getFunzione() {
        return funzione;
    }

    public void setFunzione(String funzione) {
        this.funzione = funzione;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public Ufficiale getSuperiore() {
        return superiore;
    }

    public void setSuperiore(Ufficiale superiore) {
        this.superiore = superiore;
    }

}
