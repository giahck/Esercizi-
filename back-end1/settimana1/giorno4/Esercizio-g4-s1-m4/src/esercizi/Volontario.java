package esercizi;

import java.time.LocalDateTime;

public class Volontario implements Turno {
    private int eta;
    private String nome;
    private LocalDateTime inizioCheckIn;
    private LocalDateTime fineCheckIn;
    //file CV
    private String CV;//come se fosse una descrizione
        Volontario(String nome,int eta){
            this.nome=nome;
            this.eta=eta;
        }
    @Override
    public void checkIn() {
        this.inizioCheckIn = LocalDateTime.now();
    }
    @Override
    public void checkOut() {
        this.fineCheckIn = LocalDateTime.now();
    }
    @Override
    public String  getOrario() {
        return this.nome.toUpperCase()+" Hai iniziato alle: "+this.inizioCheckIn.toString()+"hai finito alle: "+this.fineCheckIn.toString();
    }
}
