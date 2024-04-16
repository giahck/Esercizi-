package ese1;

import java.util.Scanner;

class Es1 {
    public static void stampaPariEDispari(boolean s) {
        if (s) System.out.println("La stringa è pari");
        else
            System.out.println("La stringa è dispari");
    }

    public static void stampaBisestile(boolean s) {
        if (s) System.out.println("L'anno è bisestile");
        else
            System.out.println("L'anno non è bisestile");
    }

    public boolean stringaPari(String s) {
        if (s.length() % 2 == 0)
            return true;
        else {
            return false;
        }
    }

    public static boolean annoBisestile(int anno) {
        if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void switchTre(int a) {
        switch (a) {
            case 1:
                System.out.println("uno");
                break;
            case 2:
                System.out.println("due");
                break;
            case 3:
                System.out.println("tre");
                break;
        }
    }
}


public class esercizio1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Es1 es1 = new Es1();
        es1.stampaPariEDispari(es1.stringaPari("ciao io sono Gianluca"));
        es1.stampaBisestile(es1.annoBisestile(2024));
        System.out.println("Inserisci un numero da 1 a 3");
        es1.switchTre(sc.nextInt());
        sc.nextLine();
        cicloWhile();
        contoAllaRovescia();
    }

    public static void cicloWhile() {
        String insertString = "";
        //primo modo
        while (!insertString.equals(":q")) {//finchè la stringa inserita non è uguale a :q
            System.out.println("Inserisci una stringa");
            insertString = sc.nextLine();
            for (char i : insertString.toCharArray()) {//scorro la stringa inserita
                if (i != ' ')
                    System.out.print(i + ",");
                else
                    System.out.print(" ");
            }
            System.out.println();
            //secondo modo
            String[] caratteri = insertString.split("");
            for (String i : caratteri) {
                System.out.print(i + ",");
            }
            System.out.println();
            //variante secondo modo
            System.out.println(String.join(",", caratteri));

        }
    }

    public static void contoAllaRovescia() {

        System.out.println("inserisci Numero di partenza per il timer:");
        int n = sc.nextInt();


        for (int i = n; i >= 0; i--) {
            try {
                System.out.println(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
