package esercizi;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<String> parole=new TreeSet<>(new Comparatore());
        parole.add("ciao");
        parole.add("cane");
        parole.add("gatto");
        System.out.println(parole);
        TreeSet<String> parole2=new TreeSet<>(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        parole2.add("5");
        parole2.add("8");
        parole2.add("1");
        System.out.println(parole2);
    }
}