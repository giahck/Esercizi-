package esercizio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persona> simToPerson = new ArrayList<>();//arrey di persone contente le sim
        System.out.println("registrati:");
        simToPerson.add(new Persona("Mario", 20, "M"));
        Persona p = simToPerson.get(0);
        p.sim.add(new Sim(123456));
        p.sim.add(new Sim(3698563));
        p.ricaricaSim(10, p.sim.get(0));
        p.ricaricaSim(50, p.sim.get(1));
        p.chiama(p.sim.get(0), 5);
        p.chiama(p.sim.get(1), 2);
        p.stampaSim();




    }
}
