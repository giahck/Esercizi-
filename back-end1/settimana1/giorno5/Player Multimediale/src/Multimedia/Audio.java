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
            System.out.println(this.titolo);
        for (int i=this.durata;i>=0;i--){//va a capo ogni secondo stampando tante * in base al volume
        try {
            Thread.sleep(1000); //sospensione di 1 secondo
            for (int j=this.volume;j>=0;j--)
                System.out.print("*");
            System.out.println();
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

    @Override
    public void scegli() {
        this.play();
    }
}
