package esercizio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;
import java.util.Scanner;

public class esercizio1 {
    static boolean s = true;
    static Logger logger = LoggerFactory.getLogger("logger");
     static  Scanner scan=new Scanner(System.in);
     public static void randomizza(int[] arr){


             System.out.println("inserisci posizione da 1 a 5");
             int insert = scan.nextInt();
             System.out.println(arr[insert]);
             System.out.println("vuoi continuare premi s");
             scan.nextLine();
             if (scan.nextLine().equals("S"))
                 s=true;
             else
                 s=false;

    }
    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=new Random().nextInt(1,11);
            System.out.println(arr[i]);
            /*arr[i] = (int) (Math.random() * 10) + 1;*/
        }

        while (s) {
            try {
                randomizza(arr);
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.error("error " + e.getMessage() + "retray ");

            }

        }
    }
}
