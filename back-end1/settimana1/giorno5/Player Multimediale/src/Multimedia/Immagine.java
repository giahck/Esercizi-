package Multimedia;

public class Immagine extends Multimediale implements Luminosita {
    int lume=Luminosita.lume;
    public Immagine(String Titolo) {
        super(Titolo);
    }
    @Override
    public void scegli(){
        System.out.println("-------------------------------------------");
        this.show();
        System.out.println("-------------------------------------------");
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

    @Override
    public void show() {
        String count = "IMAGGINE "+this.titolo;
        for (int i = 0; i < this.lume; i++) {
            count += "*";
        }
        System.out.println(count);

    }
}

