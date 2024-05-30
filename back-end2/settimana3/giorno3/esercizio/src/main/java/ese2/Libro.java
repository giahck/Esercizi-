package ese2;

import java.util.ArrayList;
import java.util.List;

public class Libro implements Elemento{
    private String nomeLibro;
    private double prezzo;
    private List<String> autori=new ArrayList<>();
    private List<Elemento> elementi=new ArrayList<>();

    public Libro(String nomeLibro, double prezzo) {
        this.nomeLibro = nomeLibro;
        this.prezzo = prezzo;
    }

    public String getNomeLibro() {
        return nomeLibro;
    }

    public void setNomeLibro(String nomeLibro) {
        this.nomeLibro = nomeLibro;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public List<String> getAutori() {
        return autori;
    }

    public void setAutori(List<String> autori) {
        this.autori = autori;
    }

    public List<Elemento> getElementi() {
        return elementi;
    }

    public void setElementi(List<Elemento> elementi) {
        this.elementi = elementi;
    }

    @Override
    public String getNome() {
        return nomeLibro;
    }

    @Override
    public int getDimensione() {
        return elementi.stream().mapToInt(Elemento::getDimensione).sum();
    }
    @Override
    public void stampa(){
        elementi.forEach(Elemento::stampa);
    }

}
