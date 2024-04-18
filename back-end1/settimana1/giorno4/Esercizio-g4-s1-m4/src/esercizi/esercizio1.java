package esercizi;

public class esercizio1 {
    public static Dipendente[] instanzaDip() {
        Dipendente[] dipendenti = new Dipendente[5];
        dipendenti[0] = new DipendentePartTime("giangg95", Dipartimento.PRODUZIONE, 24, 2);
        dipendenti[1] = new DipententeFullTime("rober856", Dipartimento.PRODUZIONE);
        dipendenti[2] = new DipendentePartTime("ilni8965", Dipartimento.VENDITE, 36, 3);
        dipendenti[3] = new DipententeFullTime("dragro56", Dipartimento.VENDITE);
        dipendenti[4] = new Dirigente("dragro56", Dipartimento.AMMINISTRAZIONE);

        return dipendenti;
    }

    public static void stampa(Dipendente[] dipendenti) {
        System.out.println("Dipendenti:{");
        for (Dipendente dp : dipendenti) {
             dp.checkOut();
            dp.stampaDatiDipendente();
            //dp.getOrario();//integrato direttamente nella stampa
        }

        System.out.println("}***");
    }

    public static void main(String[] args) {
        Dipendente[] dipendenti = instanzaDip();
        //stampa(dipendenti);
        //calcolo salario fullTime
        for (int i = 0; i < dipendenti.length; i++) {
            if (dipendenti[i] instanceof DipententeFullTime) {
                ((DipententeFullTime) dipendenti[i]).calcolateSalary();

            } else if (dipendenti[i] instanceof DipendentePartTime) {
                dipendenti[i].calcolateSalary();//possofarlo dal momento che ho messo il metodo come abstruuct NELLA CLASSE DIPENDENTE
            } else {
                dipendenti[i].calcolateSalary();
            }
            dipendenti[i].checkIn();//attivo a tutti il checkIn orario sara diverso perche devo inserire l'importo e riesco a simulare un in e out farro out sulla stampa finale
        }
        stampa(dipendenti);
        Volontario volotario1= new Volontario("Gianluca", 30);
        volotario1.checkIn();
        volotario1.checkOut();
        System.out.println(volotario1.getOrario());
    }
}
