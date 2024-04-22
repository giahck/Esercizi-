package it.esercizio3;

import java.util.LinkedList;
import java.util.Map;

public class esercizio3 {
    public static void main(String[] args) {
        /*Rubrica rubricaG1= new Rubrica();
        rubricaG1.add("Giovanni",1234567890);
        rubricaG1.add("Marco",356921556);
        rubricaG1.add("fernando",369828471);
        rubricaG1.add("Silvia",79858585);
        rubricaG1.remove("Silvia");
        rubricaG1.print();
        rubricaG1.add("Silvia",79858585);
        rubricaG1.searchName("Marco");
        rubricaG1.searchNumber(1234567890);*/
        LinkedList<Map<String, Integer>> rubrica = new LinkedList<>();
        Rubrica rubricaG1 = new Rubrica("Gianluca");
        rubricaG1.add("Giovanni", 1234567890);
        rubricaG1.add("Marco", 356921556);
        rubricaG1.add("fernando", 369828471);
        rubricaG1.add("Silvia", 79858585);
        rubrica.add(rubricaG1.rubrica);
        Rubrica rubricaG2 = new Rubrica("Giulia");
        rubricaG2.add("roberto", 1234567890);
        rubricaG2.add("Marco", 356921556);
        rubricaG2.add("fernando", 369828471);
        rubrica.add(rubricaG2.rubrica);

    }
}
