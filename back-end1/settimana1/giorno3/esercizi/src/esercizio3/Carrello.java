package esercizio3;

import java.util.LinkedList;
import java.util.List;

public class Carrello {
    Cliente cliente;// gia dichiarata 1
    LinkedList<Articolo> articoliNelCarrello = new LinkedList<>();// n pezzi per 1 cliente

    public Carrello(Cliente cliente, Articolo articolo) {
        this.cliente = cliente;
        this.articoliNelCarrello.add(articolo);
    }

    public void printArticoli() {
        int n = 0;
        System.out.println("Articoli nel carrello di " + cliente.nome + " " + cliente.cognome);
        for (Articolo articolo : this.articoliNelCarrello) {
            System.out.println(articolo.descrizioneArticolo + " " + articolo.prezzo + " " + articolo.nPezzi);
            n += articolo.nPezzi;
        }

    }

    public void addArticolo(Articolo articolo) {
        this.articoliNelCarrello.add(articolo);
    }
}
