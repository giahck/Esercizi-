package ese2;

public class Pagina implements Elemento{
    private String nomePagina;
    public Pagina(String nomePagina) {
        this.nomePagina = nomePagina;
    }

    @Override
    public String getNome() {
        return "";
    }

    @Override
    public int getDimensione() {
        return 1;
    }

    @Override
    public void stampa() {
        System.out.println(nomePagina);
    }
}
