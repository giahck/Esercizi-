package esercizi;

import java.util.TreeSet;

public class lambda {
    public static void main(String[] args) {
        TreeSet<String> parole=new TreeSet<>((o1, o2) -> o2.compareTo(o1));
        parole.add("ciao");
        parole.add("cane");
        parole.add("gatto");
        System.out.println(parole);
    }
}
