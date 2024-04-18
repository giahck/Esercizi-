package Multimedia;

public class Audio extends Multimediale implements Volume {
    int durata;
    int volume=Volume.volume;
    public Audio(int Durata,String Titolo){
        super(Titolo);
        this.durata=Durata;
    }
    @Override
    public void play(){
            System.out.print(this.titolo);
        for (int i=this.durata;i>=0;i--){
        try {
            Thread.sleep(100); //sospensione di 1 secondo
            System.out.print("*");//aggiunge un * per oogni secondo passato
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        }
    }
    @Override
    public void alzaVolume(){
        System.out.println("Alza il Volume di 1");
        this.volume++;
    }

    @Override
    public void abbassaVolume() {
        System.out.println("Abbassa il Volume di 1");
        this.volume--;
    }

    @Override
    public void setVolume(int volume) {

    }

    @Override
    public void getVolume() {
        System.out.println("Il volume é impostato a: "+this.volume);
    }

}
