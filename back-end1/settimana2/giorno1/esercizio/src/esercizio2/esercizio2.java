package esercizio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class esercizio2 {
    static Logger logger = LoggerFactory.getLogger("logger1");
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Kilometri km=new Kilometri();
        try {

            System.out.println(km.calcoloLitri(scan.nextInt(),scan.nextInt()));

        } catch (Eccezione e) {
            logger.warn(e.getMessage());
        }
    }
}
