package ese2;

public class Main {
    public static void main(String[] args) {
        Pagina p = new Pagina("Pagina 1");
        Sezione s = new Sezione("Sezione 1");
        s.addElemento(p);
        s.addElemento(s);
        System.out.println(s.getDimensione());
    }
}
