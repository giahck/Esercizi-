import java.util.Scanner;

public class Main {
    static String[] fiveString = new String[5];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
          stampa();
        popolaArrey();
        String[] sixString = inserisciElemInAerry("riga inserita nella posizione 4", 3);

        conactString(sixString);
    }

    public static void conactString(String[] sixString) {
        String Concat = "", ConcatReverse = "";
        for (String elem : sixString) {
            Concat += elem + " ";
        }
        for(int i=sixString.length-1;i>=0;i--){
            ConcatReverse+=sixString[i]+" ";
        }
        System.out.println("concatena in ordine di inserimento "+Concat);
        System.out.println("concatena in ordine reversso "+ConcatReverse);
        scanner.close();
    }

    public static String[] inserisciElemInAerry(String newLine, int pos) {
        String[] sixString = new String[fiveString.length + 1];
        System.arraycopy(fiveString, 0, sixString, 0, pos);
        sixString[pos] = newLine;
        System.arraycopy(fiveString, pos, sixString, pos + 1, fiveString.length - pos);
        /*for(String elem:sixString){
            System.out.println(elem);
        }*/
        return sixString;

    }

    public static void popolaArrey() {
            scanner.nextLine();
        for (int i = 0; i < 5; i++) {
            System.out.println("inserisci " + (i + 1) + " stringa");
            fiveString[i] = scanner.nextLine();
        }

    }

    public static void stampa() {
        System.out.println("inserisci primo numero");
        int a = scanner.nextInt();
        System.out.println("inserisci secondo numero");
        int b = scanner.nextInt();
        //stampa la moltiplicazione
        System.out.println(moltipliazione(a, b));
        //stampa la concatenazione della moltiplicazione e della stringa
        System.out.println("inserisci testo");
        String text = scanner.next();
        System.out.println(concatena(moltipliazione(a, b), text));

    }

    public static int moltipliazione(int a, int b) {
        return a * b;
    }

    public static String concatena(int multi, String text) {

        return multi + text;
    }

}