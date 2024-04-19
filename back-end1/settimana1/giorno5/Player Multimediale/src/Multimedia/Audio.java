package Multimedia;

public class Audio extends Multimediale implements Volume {
    int durata;
    int volume = Volume.volume;

    public Audio( String Titolo,int Durata) {
        super(Titolo);
        this.durata = Durata;
    }

    @Override
    public void play() {
        System.out.print("TRACCIA "+this.titolo);
        for (int i = this.durata; i >= 0; i--) {//va a capo ogni secondo stampando tante * in base al volume
            try {
                Thread.sleep(1000); //sospensione di 1 secondo
                for (int j = this.volume; j >= 0; j--)
                    System.out.print("*");
                System.out.print(" ");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }

    @Override
    public void alzaVolume() {
        System.out.println("Alza il Volume di 1");
        if (this.volume<VOLUME)
        this.volume++;
    }

    @Override
    public void abbassaVolume() {
        System.out.println("Abbassa il Volume di 1");
        if (this.volume>0)
        this.volume--;
    }

    @Override
    public void getVolume() {
        System.out.println("Il volume é impostato a: " + this.volume);
    }

    @Override
    public void scegli() {
        System.out.println("-------------------------------------------");
        this.play();
        System.out.println("-------------------------------------------");
    }
}
  /*  public void play() { // funziona ma non si chiude automaticamente senza non spingere nessun tasto

        System.out.println(this.titolo);

        Thread inputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Premi 'v' per alzare il volume permi b per abbasare il volume");
            while (this.start) {
                String input = scanner.nextLine();
                if (input.equals("w")) {
                    alzaVolume(); // Alza il volume quando viene premuto 'v'
                }else if (input.equals("s"))
                    abbassaVolume();
            }
            scanner.close();
        });
        inputThread.start();
        this.start=true;
        for (int i = this.durata-1; i >= 0; i--) {//va a capo ogni secondo stampando tante * in base al volume
            try {
                Thread.sleep(1000); //sospensione di 1 secondo
                for (int j = this.volume-1; j >= 0; j--)
                    System.out.print("*");
                System.out.println();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        this.start=false;
    }*/