package com.practice.java8.streams.ecommerceApp.comparators;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Order {
    private List<Product> orderedProducts;
    private long id;
    private Optional<LocalDate> orderedDate;

    private double price;

    public Order(List<Product> orderedProducts, long id, Optional<LocalDate> optionalDate) {
        this.orderedProducts = orderedProducts;
        this.id = id;
        this.orderedDate = optionalDate;
        this.price=calculateOrderPrice(this.orderedProducts, this.id);
    }
    static double calculateOrderPrice(List<Product> orderedProducts,long id){

        List<Double> collectPrices = orderedProducts.stream().map(Product::getPrice).peek(System.out::println).collect(Collectors.toList());
        //System.out.println("order #"+id+ "product prices list: "+collectPrices);
        double sum = collectPrices.stream().reduce(0.0,(a,b)->a+b);
        System.out.println("order #"+id+" total price is "+sum);
        return sum;


    }

    @Override
    public String toString() {
        return "Order{" +
                "orderedProducts=" + orderedProducts +
                ", id=" + id +
                ", orderedDate=" + orderedDate.orElse(LocalDate.of(3333,2,11)) +
                ", price=" + price +
                '}';
    }

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<Product> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Optional<LocalDate> getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Optional<LocalDate> orderedDate) {
        this.orderedDate = orderedDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
