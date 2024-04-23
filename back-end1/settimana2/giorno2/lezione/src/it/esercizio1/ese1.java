package it.esercizio1;

import java.util.*;

public class ese1 {
    public static void insert(Scanner sc, ArrayList<String> list) {
        System.out.println("Inserisci quanti elementi:");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("inserisci parola");
            list.add(sc.nextLine());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        insert(sc, list);
        System.out.println("lista completa");
        for (String l : list) {
            System.out.println(l);
        }
        //lista solo duplicati
        HashSet<String> soloDuplicati = new HashSet<>();
        System.out.println("\n lista duplicata ");
        for (String ele : list) {
            if (!soloDuplicati.add(ele))
                System.out.println(ele);
        }
        //numero di parole distinte
        Set<String> distinte = new HashSet<>(list);
        System.out.println("\n numero di parole distinte: "+distinte.size());

        //lista distinta completa
        System.out.println("\nlista distinta");
        for (String dist : distinte) {
            System.out.println(dist);
        }


    }
}