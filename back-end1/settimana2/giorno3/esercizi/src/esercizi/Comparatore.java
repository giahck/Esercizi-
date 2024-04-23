package esercizi;

import java.util.Comparator;

    public class Comparatore implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            //return o1.compareTo(o2);//se o1 è maggiore di o2 restituisce un valore positivo se o1 è minore di o2 restituisce un valore negativo se sono uguali restituisce 0
            return o2.compareTo(o1);//se o2 è maggiore di o1 restituisce un valore positivo se o2 è minore di o1 restituisce un valore negativo se sono uguali restituisce 0
        }
    }
