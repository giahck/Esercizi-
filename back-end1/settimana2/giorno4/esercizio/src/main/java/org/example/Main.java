package org.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product libri1 = new Product(100l, "herry Potter", "baby", 90);
        Product libri2 = new Product(101l, "Il signore degli anelli", "baby", 110);
        Product libri3 = new Product(102l, "Hanger games", "baby", 80);
        Product libri4 = new Product(103l, "Avengers", "baby", 220);
        //categoria libri
        Product libri5 = new Product(104l, "Il codice da Vinci", "Books", 50);
        Product libri6 = new Product(105l, "Il silenzio degli innocenti", "Books", 130);
        Product libri7 = new Product(106l, "Il miglio verde", "Books", 70);
        Product libri8 = new Product(107l, "Il sesto senso", "Books", 140);
        //catecoria Boys
        Product libri9 = new Product(108l, "Felpa", "Boys", 30);
        Product libri10 = new Product(109l, "Pantalone", "Boys", 40);
        Product libri11 = new Product(110l, "Maglietta", "Boys", 20);
        Product libri12 = new Product(111l, "Scarpe", "Boys", 50);
        //cliente
        Customer customer1 = new Customer(1l, "Mario", 1);
        Customer customer2 = new Customer(2l, "Luigi", 2);
        Customer customer3 = new Customer(3l, "Giovanni", 3);
        //order
        Order order1 = new Order(1l, "in corso", customer1, List.of(libri1, libri2, libri3, libri9), LocalDate.of(2021, 2, 10), LocalDate.of(2021, 3, 10));
        Order order2 = new Order(2l, "in corso", customer2, List.of(libri1, libri5, libri6, libri10), LocalDate.of(2022, 2, 10), LocalDate.of(2021, 3, 10));
        Order order3 = new Order(1l, "terminato", customer3, List.of(libri7, libri1, libri12, libri11), LocalDate.of(2021, 4, 10), LocalDate.of(2021, 4, 15));

        List<Product> libri = List.of(libri1, libri2, libri3, libri4, libri5, libri6, libri7, libri8, libri9, libri10, libri11, libri12);
        List<Order> ordini = List.of(order1, order2, order3);

        //ragruppa gli ordini per cliente, una mappa con chiave cliente  e il  valore della lista di ordini di quel cliente
        Map<Customer, List<Order>> m1 = ordini.stream().collect(Collectors.groupingBy(Order::getCustomer));
        m1.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
        //elenco di ordini, calcola il totale delle vendite per ogni cliente,mappa  con chiave il cliente e valore il totale dei sui ordini
        Map<Customer, Double> m2 = ordini.stream().collect(Collectors.groupingBy(Order::getCustomer, Collectors.summingDouble(p -> p.getProducts().stream().mapToDouble(Product::getPrice).sum())));
        m2.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
        //Prodotti,trova i prodotti piu costosi
        Map<String, Optional<Product>> p1 = libri.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));
        p1.forEach((k, v) -> {
            System.out.println(k + " " + v.get());
        });
        //ordini calcola la media degli ordini
        ordini.stream().flatMap(p -> p.getProducts().stream()).mapToDouble(Product::getPrice).average().ifPresent(System.out::println);
        Double media = ordini.stream().collect(Collectors.averagingDouble(p -> p.getProducts().stream().mapToDouble(Product::getPrice).sum()));
        System.out.println(media);
        //elenco di prodotti,ragruppa e calcola la somma degli importi per categoria
        Map<String, Double> p2 = libri.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice)));
        p2.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
        String prodottiString = libri.stream().map(prodotto -> prodotto.getId() + "@" + prodotto.getName() + "@"
                + prodotto.getCategory() + "@" + prodotto.getPrice()).collect(Collectors.joining("#"));
        System.out.println(prodottiString);
        File file = new File("./persistense/file.txt");
        try {
            FileUtils.writeStringToFile(file, prodottiString, Charset.defaultCharset(), true);
            System.out.println(FileUtils.readFileToString(file, "UTF-8"));
            // FileUtils.deleteQuietly(file); cancella il file
        } catch (Exception e) {
            e.printStackTrace();
        }
        //read file rimepi un arrey list
        try {
            String fileContent = FileUtils.readFileToString(file, "UTF-8");
            for (String s : fileContent.split("#")) {
                String[] split = s.split("@");
                System.out.println(split[0] + " " + split[1] + " " + split[2] + " " + split[3]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
