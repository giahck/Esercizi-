
package Multimedia;

import java.util.Scanner;
//versione piú leggibile
public class Main {
        static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Quanti Elementi vuoi creare?");
        int nElem = scanner.nextInt();
        scanner.nextLine(); // Consuma il carattere di nuova riga rimasto nel buffer
        Multimediale[] multimedia = new Multimediale[nElem];
       /* multimedia[0]=new Video("sad",5);
        multimedia[1]=new Video("Ciao",5);
        multimedia[2]=new Video("Cisdg",5);*/
        for (int i = 0; i < nElem; i++) {
            multimedia[i] = instanElement(i);
        }

        String stringa="";
        while (!stringa.equals(":q")){
            stringa="";
            for (int i=0; i<nElem;i++) {
                System.out.println(multimedia[i].titolo);
            }
            System.out.println("Scegli cosa vuoi vedere o sentire digitando tra 1 e"+nElem);
                int n = scanner.nextInt();
            if (nElem>=n) {
                multimedia[n - 1].scegli();
                System.out.println("Se vuoi uscire inserisci :q");
                scanner.nextLine();
                stringa=scanner.nextLine();
            }else {
                System.out.println("Se vuoi uscire inserisci :q");
            scanner.nextLine();
                stringa=scanner.nextLine().toLowerCase();
            }
        };
        scanner.close();

    }

    public static Multimediale instanElement( int id) {
        System.out.println(id + "  Premi un tasto per scegliere tra: V (Video), I (Immagine), A (Audio)");
        String elem = scanner.nextLine().toUpperCase();
        switch (elem) {
            case "V":
                return videoIn();//accetta sia il volume che la luminosita
            case "I":
                return immagineIn();//accetta solo la luminosita
            case "A":
                return audioIn();//accetta solo il volume
            default:
                System.out.println("Scelta non valida. Riprova.");
                return instanElement( id);
        }
    }

    public static Video videoIn() {//quindi richiama sia luminosita che volume
        System.out.println("Inserisci titolo video e durata (intero):");
        String titolo = scanner.nextLine();
        int durata = scanner.nextInt();
        scanner.nextLine();
        Video video = new Video(titolo, durata);
        gestisciVolume( video);
        gestisciLuminosita(video);
        return video;
    }

    public static Immagine immagineIn() {//chiama  solo luminosita
        System.out.println("Inserisci titolo Immagine:");
        String titolo = scanner.nextLine();
        Immagine immagine = new Immagine(titolo);
        gestisciLuminosita( immagine);
        return immagine;
    }

    public static Audio audioIn() {//chiama solo volume
        System.out.println("Inserisci titolo Audio e durata (intero):");
        String titolo = scanner.nextLine();
        int durata = scanner.nextInt();
        scanner.nextLine();
        Audio audio=new Audio(titolo,durata);
        gestisciVolume(audio);
        return audio;
    }

    public static void gestisciVolume(Volume media) {//modifica il volume in base all'oggeto passato fa riferimento all interffacia volume
        String scelta;
        do {
            media.getVolume();
            System.out.println("Se vuoi alsare il volume premi S, se vuoi abbassarlo premi T, premi N per uscire:");
            scelta = scanner.nextLine().toUpperCase();//ACCETTA SIA s CHE S
            if (scelta.equals("S")) {
                media.alzaVolume();
            } else if (scelta.equals("T")) {
                media.abbassaVolume();
            }
        } while (!scelta.equals("N"));
    }

    public static void gestisciLuminosita( Luminosita luminosita) {///modifica la luminosita in base all'oggeto passato fa riferimento all interffacia Luminosita
        String scelta;
        do {
            luminosita.getLume();
            System.out.println("Se vuoi alzare la luminosita premi S, se vuoi abbassarla premi T, premi N per uscire:");
            scelta = scanner.nextLine().toUpperCase();
            if (scelta.equals("S")) {
                luminosita.alzaLume();
            } else if (scelta.equals("T")) {
                luminosita.abbassaLume();
            }
        } while (!scelta.equals("N"));
    }
}


//versione iniziale non ricorsiva
 /*   static Scanner scanner = new Scanner(System.in);
    public static Multimediale[] instanzaMultimedia() {
        Multimediale[] multimedia = new Multimediale[3];
        multimedia[0]=new Video("pulp",5);
        ((Video) multimedia[0]).alzaVolume();
        ((Video) multimedia[0]).abbassaLume();
        multimedia[1]=new Audio("caparezza",5);
        multimedia[2]=new Immagine("pulp");
//scomendando questo blocco
//puoi cambiare il volume su Video e puoi cambiare luminosita su Imaggine, audio lasciato libero
      */
/*  System.out.println("Quanti Elementi vuoi creare?");
        int nElem = scanner.nextInt();
        Multimediale[] multimedia = new Multimediale[nElem];
        for (int i = 0; i < nElem; i++) {
            scanner.nextLine();
            System.out.println(i + " Premi un tasto pper scegliere tra: V,I,A");
            String elem = scanner.nextLine();
            if (elem.equals("V")) {
                System.out.println("inserisci titolo video e durata(intero):");//non richiedo unaltro out faccio diretto
                multimedia[i] = new Video(scanner.nextLine(), scanner.nextInt());
                String enter;
                do {

                    System.out.println("Se vuoi impostare il volume premi S se vuoi abbasarlo T Premi N se non vuoi é impostato di defoult a 5");
                    String s = scanner.nextLine();
                    if (s.equals("S"))
                        ((Video) multimedia[i]).alzaVolume();
                    else if (s.equals("T")) {
                        ((Video) multimedia[i]).abbassaVolume();
                    }
                    System.out.println("il livello del volume é:" + ((Video) multimedia[i]).volume + " Se vuoi cambiare volume: premi s");
                    enter = scanner.nextLine();

                } while (enter.equals("S"));
            } else if (elem.equals("I")) {
                System.out.println("inserisci titolo Immagine:");
                multimedia[i] = new Immagine(scanner.nextLine());
                String enter;
                do {
                    System.out.println("Se vuoi impostare la luminosita premi S se vuoi abbasarlo T Premi N se non vuoi é impostato di defoult a 5");
                    String s = scanner.nextLine();
                    if (s.equals("S"))
                        ((Immagine) multimedia[i]).alzaLume();
                    else if (s.equals("T")) {
                        ((Immagine) multimedia[i]).abbassaLume();
                    }
                    System.out.println("il livello della luminosita é:" + ((Immagine) multimedia[i]).lume + " Se vuoi cambiare Luminosita: premi S");
                    enter = scanner.nextLine();

                } while (enter.equals("S"));


            } else if (elem.equals("A")) {
                System.out.println("inserisci titolo Audio e durata(intero):");
                multimedia[i] = new Audio(scanner.nextLine(), scanner.nextInt());
            } else i--;//in modo che se sbagli arrey sara sempre pieno

        }*//*



        return multimedia;
    }

    public static void main(String[] args) {
        Multimediale[] multimedia = instanzaMultimedia();
        String stringa;
        do {
            System.out.println("Vuoi uscire inserisci :q");
            stringa=scanner.nextLine();
        } while (!stringa.equals(":q"));

       */
/* for (Multimediale media : multimedia) {
            media.scegli();
        }*/
/* multimedia[0].play();
        //dal momento che non metto l'interfaccia nella super classe faccio il casting esplicito
        ((Audio)multimedia[0]).abbassaVolume();
        ((Audio)multimedia[0]).alzaVolume();
        ((Audio)multimedia[0]).alzaVolume();
        ((Audio)multimedia[0]).getVolume();*//*



    }
}*/
