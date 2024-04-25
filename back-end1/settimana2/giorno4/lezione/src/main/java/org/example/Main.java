package org.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //categoria baby
        Product libri1 = new Product(100l, "herry Potter", "baby", 90);
        Product libri2 = new Product(101l, "Il signore degli anelli", "baby", 110);
        Product libri3 = new Product(102l, "Hanger games", "baby", 80);
        Product libri4 = new Product(103l, "Avengers", "baby", 220);
        //categoria libri
        Product libri5 = new Product(104l, "Il codice da Vinci", "Books", 50);
        Product libri6 = new Product(105l, "Il silenzio degli innocenti", "Books", 130);
        Product libri7 = new Product(106l, "Il miglio verde", "Books", 70);
        Product libri8 = new Product(107l, "Il sesto senso", "Books", 130);
        //catecoria Boys
        Product libri9 = new Product(108l, "Felpa", "Boys", 30);
        Product libri10 = new Product(109l, "Pantalone", "Boys", 40);
        Product libri11 = new Product(110l, "Maglietta", "Boys", 20);
        Product libri12 = new Product(111l, "Scarpe", "Boys", 50);

        List<Product> libri = List.of(libri1, libri2, libri3, libri4, libri5, libri6, libri7, libri8, libri9, libri10, libri11, libri12);

        List<Double> l1 = libri.stream().filter(p -> p.getPrice() > 99).map(Product::getPrice).distinct().collect(Collectors.toList());
        System.out.println(l1);
        Map<Long, Double> l2 = libri.stream().filter(p -> p.getPrice() > 99).collect(Collectors.toMap(Product::getId, p -> p.getPrice()));
        System.out.println(l2);
        Map<String, List<Product>> l3 = libri.stream().collect(Collectors.groupingBy(Product::getCategory));
        l3.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
        Map<String, Long> l4 = libri.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        System.out.println(l4);

        libri.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice))).forEach((k, v) -> System.out.println(k + " " + v));
        libri.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice))).forEach((k, v) -> System.out.println(k + " " + v));

        DoubleSummaryStatistics somma = libri.stream().map(Product::getPrice).collect(Collectors.summarizingDouble(Double::doubleValue));
        System.out.println(somma);
        Map<Boolean, List<Product>> l6 = libri.stream().collect(Collectors.partitioningBy(p -> p.getPrice() > 99));
        l6.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });

        Optional<Double> sommaPrezzi = libri.stream()
                .map(Product::getPrice)
                .collect(Collectors.reducing(0.0, (p1, p2) -> p1 + p2)).describeConstable();

        sommaPrezzi.ifPresent(System.out::println);

        libri.stream().sorted(Comparator.comparingDouble(Product::getPrice).reversed()).forEach(System.out::println);

     /*   File file=new File("./persistense/file.txt");
        try{
        FileUtils.writeStringToFile(file, "g\n", Charset.defaultCharset(), true);
            System.out.println( FileUtils.readFileToString(file,"UTF-8"));
           // FileUtils.deleteQuietly(file); cancella il file

        }catch (Exception e) {
            e.printStackTrace();
        }*/
        System.out.println("-------------------------------------------------");
        String strProdotto = libri.stream()
                .map(p -> p.getId() + "--" + p.getName() + "--"+p.getCategory()+"--" + p.getPrice())
                .collect(Collectors.joining("\n"));

        System.out.println(strProdotto);
            File file=new File("./persistense/file.txt");
        try{
        FileUtils.writeStringToFile(file, strProdotto, Charset.defaultCharset(), true);
            System.out.println( FileUtils.readFileToString(file,"UTF-8"));
           // FileUtils.deleteQuietly(file); cancella il file

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}