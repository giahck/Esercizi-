package esercizi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Rettangolo> rettangoli = new ArrayList<>();
        System.out.println("quanti rettangoli vuoi: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
        System.out.println("Inserisci l'altezza del rettangolo: ");
        float altezza = sc.nextFloat();
        System.out.println("Inserisci la larghezza del rettangolo: ");
        float larghezza = sc.nextFloat();
        rettangoli.add(new Rettangolo(altezza,larghezza));
        }
        for (Rettangolo r : rettangoli) {
            System.out.println("Rettangolo: ");
            r.printRettangolo();
        }

    }
}
