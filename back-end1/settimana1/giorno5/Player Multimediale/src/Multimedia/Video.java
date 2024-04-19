package Multimedia;
//classe separata da audio soluzione con riscrittura del volume altra soluzione classe video estesa da audio
public class Video extends Multimediale implements Volume,Luminosita{
        int durata;
        int volume=Volume.volume;
        int lume=Luminosita.lume;
    public Video(String Titolo,int Durata) {
        super(Titolo);
        this.durata=Durata;
    }
    @Override
    public void scegli(){
    this.play();
    }
    @Override
    public void play(){
        System.out.println(this.titolo);
        for (int i=this.durata;i>=0;i--){//va a capo ogni secondo stampando * in base al volume
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
    public void alzaLume() {
        System.out.println("Alza la Luminosita di 1");
        this.lume++;
    }

    @Override
    public void abbassaLume() {
        System.out.println("abassa la Luminosita di 1");
        this.lume--;
    }

    @Override
    public void getLume() {
        System.out.println("Il volume é impostato a: "+this.lume);
    }
}
/*//supponendo che classe audio sia il player totale e non una traccia//ma sfrutto la classe Audio come traccia in questo caso
class Video extends Audio implements Luminosita{
    int durata;
    int lume=Luminosita.lume;
    public Video(String Titolo,int Durata) {
        super(Durata, Titolo);
    }
    @Override
    public void getVolume() {
        System.out.println("Il volume é impostato a: "+this.volume);
    }

    @Override
    public void alzaLume() {
        System.out.println("Alza la Luminosita di 1");
        this.lume++;
    }

    @Override
    public void abbassaLume() {
        System.out.println("abassa la Luminosita di 1");
        this.lume--;
    }

    @Override
    public void getLume() {
        System.out.println("Il volume é impostato a: "+this.lume);
    }
}*/
