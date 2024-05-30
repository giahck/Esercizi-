package ese2;

import java.util.ArrayList;
import java.util.List;

public class Sezione implements Elemento {
 private List<Elemento> elementi=new ArrayList<>();
private String nomeSez;

    public Sezione(String nomeSez) {
        this.nomeSez = nomeSez;
    }

    public void addElemento(Elemento e){
        elementi.add(e);
    }

    @Override
    public String getNome() {
        return nomeSez;
    }

    @Override
    public int getDimensione() {
        return elementi.stream().mapToInt(Elemento::getDimensione).sum();
    }
    @Override
    public void stampa(){
        System.out.println(nomeSez);
        elementi.forEach(Elemento::stampa);
    }
}
