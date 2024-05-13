package it.M2_S1_G1.esercizio.EnumS;

public enum EnumIngredienti {
    BASILICO(0.20), POMODORO(0.30), MOZZARELLA(0.50), FUNGHI(0.40), PROSCIUTTO(0.70),
    SALAME(0.60), OLIVE(0.30), CARCIOFI(0.50), CIPOLLA(0.30), PEPERONI(0.50),
    SALSICCIA(0.60), PATATE(0.40), PANCETTA(0.70), GORGONZOLA(0.60), RUCOLA(0.40),
    GRANA(0.50), POMODORINI(0.40), TONNO(0.60), GAMBERETTI(0.80), ANANAS(0.50),
    UOVA(0.60), ZUCCHINE(0.40), MELANZANE(0.50), PEPERONCINO(0.30), PARMIGIANO(0.60),
    POMODORO_CILIEGINO(0.40), POMODORO_SECCO(0.50), POMODORO_PACHINO(0.50),
    POMODORO_PICCANTE(0.40), POMODORO_SICILIANO(0.50), POMODORO_CHERI(0.40),
    ALICI(0.70), MOZZARELLABUFALA(0.80),FIORI(0.60);
    private double prezzo;

    EnumIngredienti(double prezzo) {
        this.prezzo = prezzo;
    }

    public double getPrezzo() {
        return prezzo;
    }
}
