import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("insert lato 1");
        double l1 = scanner.nextDouble();
        System.out.println("insert lato 2");
        double l2 = scanner.nextDouble();
        double perimmetroD = perimetroRettangolo(l1, l2);
        int perimetro = (int) perimmetroD;//trasformo in int un double
        pariDispari(perimetro);
        areaTriangolo((float)l1,10,10);

    }

    public static double perimetroRettangolo(double l1, double l2) {
        //2p=(b*h)*2
        System.out.println("perimetro rettangolo " + (l1 + l2) * 2);
        return (l1 + l2) * 2;
    }

    public static int pariDispari(int n) {
        //ternario (condizione)?(se vero):(se falso)
        System.out.println("il numero é " + (n % 2 == 0 ? "pari" : "dispari"));
        return n % 2 == 0 ? n : n + 1;
    }

    private static void areaTriangolo(float l1, float l2, float l3) { //non restituisco qui
        //A=rad(p*(p-a)*(p-b)*(p-c))
        float a =(float) Math.sqrt((l1+l2+l3)/2*((l1+l2+l3)/2-l1)*((l1+l2+l3)/2-l2)*((l1+l2+l3)/2-l3));
        System.out.println("l'area del triangolo é "+a);
    }
}