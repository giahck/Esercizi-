package esercizio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class esercizio2 {
    static Logger logger = LoggerFactory.getLogger("logger");
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Kilometri km=new Kilometri();
        try {
            System.out.println(km.calcoloLitri(5,3));

        } catch (Eccezione e) {
            logger.error(e.getMessage());
        }
    }
}
