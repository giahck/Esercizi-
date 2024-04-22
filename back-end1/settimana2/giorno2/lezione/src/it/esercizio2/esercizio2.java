package it.esercizio2;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class esercizio2 {
    public static void insert(Scanner sc, ArrayList<Integer> list) {
        Random rand = new Random();
        System.out.println("Inserisci quanti elementi:");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            list.add((rand.nextInt(100)));
        }
        System.out.println("lista completa non  ordinata");
        for (int l : list) {
            System.out.println(l);
        }
        list.sort(null);

    }

    public static ArrayList<Integer> reverse(ArrayList<Integer> list) {
        ArrayList<Integer> reverseList = new ArrayList<>(list);
        Collections.reverse(reverseList);
        return reverseList;
    }

    public static void pariEdispari(ArrayList<Integer> list, boolean p) {
        for (int i = 0; i < list.size(); i++) {
            if (p && i % 2 == 0) {
                System.out.println(list.get(i));
            } else if (!p && i % 2 != 0) {
                System.out.println(list.get(i));
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> listRevers = new ArrayList<>();
        insert(sc, list);
        System.out.println("lista completa ordinata");
        for (int l : list) {
            System.out.println(l);
        }
        System.out.println("lista completa ordinata reversa");
        listRevers = reverse(list);
        for (int l : listRevers) {
            System.out.println(l);
        }
        System.out.println("pari e dispari");
        pariEdispari(list, false);

    }
}
