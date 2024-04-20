package esercizio2;
//km/l=distanza percorsa/litri di carburante consumati

public class Kilometri {

    static double calcoloLitri(double distanza, double litri)throws Eccezione {
        if (litri==0)
           throw new Eccezione("Litri cannot be zero");//rispedisci errore al main con questa scritta nel caso fosse 0
        return distanza / litri;
    }
}
