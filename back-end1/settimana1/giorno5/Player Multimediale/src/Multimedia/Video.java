package Multimedia;
//classe separata da audio soluzione con riscrittura del volume altra soluzione classe video estesa da audio
/*public class Video extends Multimediale implements Volume{
        int durata;
        int volume=Volume.volume;
    public Video(String Titolo,int Durata) {
        super(Titolo);
        this.durata=Durata;
    }

    @Override
    protected void play() {
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
}*/
//supponendo che classe audio sia il player totale e non una traccia//ma sfrutto la classe Audio come traccia in questo caso
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
}
