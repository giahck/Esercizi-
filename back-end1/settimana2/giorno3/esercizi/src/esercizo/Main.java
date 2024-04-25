package esercizo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        List<Product> ese1 = libri.stream().filter(p -> p.getCategory().equals("Books") && p.getPrice() > 100).toList();
        System.out.println(ese1);
        List<Order> ordini = List.of(order1, order2, order3);
        //stampa tutti i prodotti
        List<Order> orders = ordini.stream().filter(p -> p.getProducts().stream().anyMatch(product -> product.getCategory().equals("baby"))).toList();
        orders.forEach(ordine -> System.out.println(ordine));
        //stampa Boys maggiorato del 10%

        /*List<Order> ordiniBaby=ordini.stream()
                .filter(order -> {
                    List<Product> prodottiBaby=order.getProducts().stream().
                            filter(product -> product.getCategory()
                            .equals("baby")).toList();
                    return !prodottiBaby.isEmpty();
                }).toList();*/
        //libri boys 10%
        List<Product> Boys = libri.stream().filter(p -> p.getCategory().equals("Boys")).map(p -> {
            p.setPrice(p.getPrice() * 0.9);
            return p;
        }).toList();
        System.out.println(Boys);
        //stampa i prodoti tra aprile e maggio
        ordini.stream().filter(p ->p.getCustomer().getTier()==1&&  p.getDate()
                .isAfter(LocalDate.of(2021, 1, 31)) && p.getDate().isBefore(LocalDate.of(2021, 5, 1)))
                .forEach(System.out::println);
    }

}
