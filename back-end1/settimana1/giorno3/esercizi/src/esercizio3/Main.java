package esercizio3;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("1", "Mario", "Rossi", "rS@rst.com", java.time.LocalDate.now());//lodate.of(2021, 1, 1));
        Cliente cliente2 = new Cliente("2", "Luca", "Bianchi", "Lb@dsaf.com", java.time.LocalDate.of(2020, 6, 29));
        Articolo articolo1 = new Articolo("martello", "mt25", 12.35, 67);
        Articolo articolo2 = new Articolo("Paletta", "pt02", 6.75, 96);
        Articolo articolo3 = new Articolo("Secchiello", "si96", 15.65, 15);
        Carrello carrello = new Carrello(cliente1, articolo1);
        carrello.printArticoli();
        carrello.addArticolo(articolo3);
        carrello.printArticoli();

    }
}
