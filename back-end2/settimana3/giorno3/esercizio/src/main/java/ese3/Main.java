package ese3;

public class Main {
    public static void main(String[] args) {
        Generale generale = new Generale();
        Colonnello colonnello = new Colonnello();
        Tenente tenente = new Tenente();
        Maggiore maggiore = new Maggiore();
        Capitano capitano = new Capitano();

        capitano.setSuperiore(maggiore);
        maggiore.setSuperiore(tenente);
        tenente.setSuperiore(colonnello);
        colonnello.setSuperiore(generale);
        capitano.controlloStipendio(4500);
    }

}
