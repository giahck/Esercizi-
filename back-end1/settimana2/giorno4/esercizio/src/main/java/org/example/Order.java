package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class Order {
    private Long id;
    private String Status;
    private Customer customer;
    private List<Product> products;
    private LocalDate date;
    private LocalDate deliveryDate;
    public  Order(Long id, String Status, Customer customer, List<Product> products, LocalDate date, LocalDate deliveryDate){
        this.id = id;
        this.Status = Status;
        this.customer = customer;
        this.products = products;
        this.date = date;
        this.deliveryDate = deliveryDate;
    }
    public long getId(){
        return id;
    }
    public String getStatus(){
        return Status;
    }
    public Customer getCustomer(){
        return customer;
    }
    public List<Product> getProducts(){
        return products;
    }
    public LocalDate getDate(){
        return date;
    }
    public LocalDate getDeliveryDate(){
        return deliveryDate;
    }
    public void setId(long id){
        this.id = id;
    }
    public void setStatus(String Status){
        this.Status = Status;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public void setProducts(List<Product> products){
        this.products = products;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }
    public void setDeliveryDate(LocalDate deliveryDate){
        this.deliveryDate = deliveryDate;
    }
    @Override
    public String toString(){
        return "Order{" +
                "id=" + id +
                ", Status='" + Status + '\'' +
                ", customer=" + customer +
                ", products=" + products +
                ", date=" + date +
                ", deliveryDate=" + deliveryDate +
                '}';
    }

}

