package epicode.ese;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Info info = new Info("Mario", "Rossi", new Date());
        InfoAdapter infoAdapter = new InfoAdapter(info);
        String nomeCompleto = infoAdapter.getNomeCompleto();
        int eta = infoAdapter.getEta();
        System.out.println("Nome completo: " + nomeCompleto);
        System.out.println("Eta: " + eta);
    }
}