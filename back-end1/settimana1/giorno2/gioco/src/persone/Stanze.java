package persone;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;

class Person {//creazione della persona che vera spedita dentro la lista
    public String nome;
    int posX = 0;
    int posY = 0;

    public Person(String name) {
        this.nome = name;
    }
}

class Mappa {
    List<Mappa> mappa = new ArrayList<>();
    int posX = 0;
    int posY = 0;
    int posId = 0;

    public Mappa(int x, int y, int id) {
        this.posX = x;
        this.posY = y;
        this.posId = id;
    }
}

class ConsoleStart {
    int players = 0;//num giocatori
    List<Person> list = new ArrayList<>();//richiamo da console list

    public void insertGamer() {
        System.out.println("Inserisci quanti giocatori:");
        this.players = GlobalScanner.sc.nextInt();
        for (int i = 0; i < this.players; i++) {
            System.out.println("Inserisci nome giocatore n°" + (i + 1));
            String name = GlobalScanner.sc.next();
            list.add(new Person(name));//aggiungo i giocatori alla lista
           /* Person p= this.list.get(i);
            p.posX=i;*/
        }
        System.out.println("I giocatori sono:");
        for (int i = 0; i < this.list.size(); i++) {
            System.out.println((i + 1) + ")" + list.get(i).nome);
        }
        /*startGame();*/
    }

   /* public void startGame() {

    }*/

    public void player() {
     

    }

}


public class Stanze {
    public static void main(String[] args) {
        ConsoleStart console = new ConsoleStart();
        console.insertGamer();

        console.player();

 /*      List<Person> list=new ArrayList<>();
         list.add(new Person("Mario"));
         System.out.println(list.get(0).nome);*/

        /*startTimer(5);*/ // Timer will run for 5 seconds
    }


    public static void startTimer(int seconds) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            int count = seconds;

            @Override
            public void run() {
                if (count >= 0) {
                    System.out.println("Timer: " + count + " seconds remaining");
                    count--;
                } else {
                    System.out.println("Timer finished!");
                    timer.cancel(); // Stop the timer
                }
            }
        }, 0, 1000); // Schedule the task to run every 1 second
    }
}
