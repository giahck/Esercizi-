package esercizi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class stream {
    public static void main(String[] args) {
        List<String> parole = List.of("ciao", "cane", "gatto", "orso", "Balena", "Cavallo");
        parole.stream().peek(System.out::println).filter(p -> p.length()>4).forEach(System.out::println);
        List<String> words = List.of("hello", "world", "how", "are", "you");

        // Concatenazione delle stringhe utilizzando collect con StringBuilder
        String concatenatedString = words.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        System.out.println("Concatenated String: " + concatenatedString);
        concatenatedString=words.stream()
                .collect(Collectors.joining(", "));
System.out.println("Concatenated String: " + concatenatedString);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

//get list of unique squares
       numbers= numbers.stream().map( i -> i*i).distinct().toList();
        System.out.println("Squares List: "+numbers);

    }
}
