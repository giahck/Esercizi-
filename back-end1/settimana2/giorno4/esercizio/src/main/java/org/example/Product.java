package org.example;

import java.util.ArrayList;

public class Product {
    private Long id;
    private String name;
    private String category;
    private double price;
    public Product(Long id, String name, String category, double price){
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
    public String getCategory(){
        return category;
    }
    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setPrice(double price){
        this.price = price;
    }
    @Override
    public String toString(){
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }


}
