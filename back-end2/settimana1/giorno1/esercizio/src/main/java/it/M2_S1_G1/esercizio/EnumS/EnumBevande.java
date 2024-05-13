package it.M2_S1_G1.esercizio.EnumS;

public enum EnumBevande {
    ACQUA(1.0), BIRRA(2.5), BIBITA(1.5), VINO(4.0), COCKTAIL(7.0), CAFFE(1.0), THE(1.0), INFUSO(1.0),
    LATTE(1.5), YOGURT(2.0), FRULLATO(3.0), SPREMUTA(2.0), BIBITAENERGETICA(3.5), BIBITASPORTIVA(2.5),
    BIBITAFERMENTATA(2.5), BIBITAFRIZZANTE(1.5), BIBITAGASSATA(1.5), BIBITANONALCOLICA(1.5),
    BIBITAALCOLICA(4.0), CHINOTTO(1.5), CIOCCOLATA(2.0), CIOCCOLATOCALDO(2.0), CIOCCOLATOFREDDO(2.5),
    CIOCCOLATOSO(2.0), COCA(1.5), COCA_ZERO(1.5), COLAZERO(1.5), COLALIGHT(1.5), COLADIET(1.5),
    COLAENERGETICA(2.0), COLASPORTIVA(1.5), COLAFERMENTATA(1.5), COLAFRIZZANTE(1.5), COLAGASSATA(1.5),
    COLANONALCOLICA(1.5), COLAALCOLICA(3.0), FANTA(1.5), SPRITE(1.5), GIN(6.0), RUM(5.0), WHISKEY(5.0),
    MARGARITA(8.0), MOJITO(7.0), MULE(7.0), CIOCCOLATOMARTINI(8.0), TIRAMISUMARTINI(8.0), COSMOPOLITAN(7.0),
    MARTINISPECIAL(9.0);


    private double prezzo;

    EnumBevande(double prezzo) {
        this.prezzo = prezzo;
    }

    public double getPrezzo() {
        return prezzo;
    }
}

