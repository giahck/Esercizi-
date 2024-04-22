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
        System.out.println("-------------------------------------------");
    this.show();
    this.play();
        System.out.println("-------------------------------------------");
    }
    @Override
    public void play() {
        System.out.print("VIDEO "+this.titolo);
        for (int i = this.durata; i > 0; i--) {//va a capo ogni secondo stampando tante * in base al volume
            try {
                Thread.sleep(1000); //sospensione di 1 secondo
                for (int j = this.volume; j > 0; j--)
                    System.out.print("*");
                System.out.print(" ");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
    }
    @Override
    public void alzaVolume(){
        System.out.println("Alza il Volume di 1");
        this.volume++;
    }

    @Override
    public void abbassaVolume() {
        System.out.println("Abbassato il Volume di 1");
        this.volume--;
    }

    @Override
    public void getVolume() {
        System.out.println("Il volume é impostato a: "+this.volume);
    }
    @Override
    public void alzaLume() {
        System.out.println("Alza la Luminosita di 1");
        if (this.lume<Luminosita.LUME)
        this.lume++;
    }

    @Override
    public void abbassaLume() {
        System.out.println("abassa la Luminosita di 1");
        if (this.lume>0)
        this.lume--;
    }

    @Override
    public void getLume() {
        System.out.println("La luminosita é impostato a: "+this.lume);
    }

    @Override
    public void show() {
        String count = "luminosita impostata:"+this.titolo;
        for (int i = 0; i < this.lume; i++) {
            count += "!";
        System.out.println(count);
        }

    }
}
//non utilizato in quanto non rispetta la traccia ma funzionante
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
