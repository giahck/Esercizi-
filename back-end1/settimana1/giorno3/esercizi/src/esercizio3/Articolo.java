package esercizio3;

public class Articolo {
    String codiceArticolo;
    String descrizioneArticolo;
    double prezzo;
    int nPezzi;

    public Articolo(String descrizione, String codiceArticolo, double prezzo, int nPezzi) {
        this.codiceArticolo = codiceArticolo;
        this.prezzo = prezzo;
        this.nPezzi = nPezzi;
        this.descrizioneArticolo = descrizione;
    }
}
