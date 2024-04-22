package esercizio3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Banca {
    static Logger logger = LoggerFactory.getLogger("logger1");
    public static void main(String args[]) {
        ContoCorrente conto1 = new ContoCorrente("Grossi Mario", 0);

        System.out.println("Saldo conto: " + conto1.restituisciSaldo());

        try {
            conto1.preleva(1750.5);

            System.out.println("Saldo conto: " + conto1.restituisciSaldo());
        } catch (BancaException e) {
            logger.warn("Errore durante il prelievo: " + e);

            /*e.printStackTrace();*/
        }

        ContoOnLine conto2 = new ContoOnLine("Rossi Luigi", 0, 1500);

        conto2.stampaSaldo();

        try {
            conto2.preleva(2000);

            conto2.stampaSaldo();

        } catch (BancaException e) {
            logger.error("Errore durante il prelievo: " + e);
            e.printStackTrace();
        }
    }
}
