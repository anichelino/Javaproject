package com.practice.java8.streams.ecommerceApp.collectors;

public class Product {
    private String name;
    private long id;
    private String type;
    private double price;

    public Product(String name, long id, String type, double price) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
