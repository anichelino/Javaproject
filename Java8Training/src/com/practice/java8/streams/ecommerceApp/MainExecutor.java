package com.practice.java8.streams.ecommerceApp;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.List.*;

public class MainExecutor {
    public static void main(String[] args) {

        Product product1= new Product("toothbrush",1,"Household",2.34) ;
        Product product2= new Product("Multimeter",2,"Electricalhold",22.34) ;
        Product product3= new Product("shoes",3,"Personalstuff",200.34) ;
        Product product4= new Product("Notebook",4,"Personalstuff",2000.34) ;
        Product product5= new Product("T-shirt",5,"Personalstuff",22000.14) ;
        Product product6= new Product("Subwoofer",6,"Household",122.34) ;
        Product product7= new Product("Headphones",7,"Personalstuff",322.34) ;
        Product product8= new Product("VoltageSupplier",8,"Electricalhold",2.34) ;
        Product product9= new Product("Chair",9,"Household",52.34) ;
        Product product10= new Product("Shelves",10,"Household",182.34) ;
        List<Product> allproductsList= List.of(product1,product2,product3,product4,product5,product6,product7,product8,product9,product10);
        List<Product> order1Products=List.of(product1,product6,product7);
        List<Product> order2Products=List.of(product2,product3,product4,product5);
        List<Product> order3Products=List.of(product5,product6,product7,product8,product9);
        List<Product> order4Products=List.of(product1,product6,product7,product10,product2);
        List<Product> order5Products=List.of(product1,product6,product7,product4,product5);
        List<Product> order7Products=List.of(product2,product6,product7,product4,product10);
        List<Product> order8Products=List.of(product3,product6,product8,product4,product10);
        List<Product> order9Products=List.of(product10,product6,product9,product8,product2);
        List<Product> order10Products=List.of(product9,product6,product1,product7,product2);
       // Order order1= new Order(order1Products,1,new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime());
        Order order1= new Order(order1Products,1,Optional.empty());
        Order order2= new Order(order2Products,2,Optional.of(new GregorianCalendar(2023, Calendar.FEBRUARY, 11).getTime()));
        Order order3= new Order(order3Products,3,Optional.of(new GregorianCalendar(2012, Calendar.FEBRUARY, 11).getTime()));
        Order order4= new Order(order4Products,4,Optional.of(new GregorianCalendar(2013, Calendar.FEBRUARY, 11).getTime()));
        Order order5= new Order(order5Products,5,Optional.of(new GregorianCalendar(2004, Calendar.FEBRUARY, 11).getTime()));
        Order order6= new Order(allproductsList,6,Optional.of(new GregorianCalendar(2005, Calendar.FEBRUARY, 11).getTime()));
        Order order7= new Order(order7Products,7,Optional.of(new GregorianCalendar(2006, Calendar.FEBRUARY, 11).getTime()));
        Order order8= new Order(order8Products,8,Optional.of(new GregorianCalendar(2009, Calendar.FEBRUARY, 11).getTime()));
        Order order9= new Order(order9Products,9,Optional.of(new GregorianCalendar(2010, Calendar.FEBRUARY, 11).getTime()));
        Order order10= new Order(order10Products,10,Optional.of(new GregorianCalendar(2014, Calendar.FEBRUARY, 12).getTime()));
        List<Order> allOrderList= List.of(order1,order2,order3,order4,order5,order6,order7,order8,order9,order10);
        List<Order> allOrderList2= List.of(order1,order2,order3,order4,order5,order6,order7,order8,order9,order10);
        System.out.println("printing all orders without order");
        allOrderList2.stream().forEachOrdered(System.out::println);

        //List<List<Product>> collect = allOrderList.stream().map(order -> order.getOrderedProducts()).collect(Collectors.toList());
        //System.out.println("----------------------------------");

        //collect.forEach(System.out::println);
        //Stream<Product> productStream = collect.stream().flatMap(products -> products.stream());
        Stream<Product> productStream = allOrderList.stream().map(order -> order.getOrderedProducts()).flatMap(Collection::stream);
        //productStream.filter(pr->pr.getPrice()<20).forEach(System.out::println);
        /*OptionalDouble priceAverage=productStream.mapToDouble(Product::getPrice).average();
        System.out.println(priceAverage.getAsDouble());
        */OptionalDouble priceMax=productStream.mapToDouble(Product::getPrice).max();
        System.out.println(priceMax.getAsDouble());

        //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!----------------------------------");
        //productStream.forEach(System.out::println);


        //sort orders

        Stream<Order> sortedOrdersByDate = allOrderList.stream().sorted(
                (o1, o2) -> {
                    if (o1.getOrderedDate().isPresent() && o2.getOrderedDate().isPresent()){
                        if (o1.getOrderedDate().get().compareTo(o2.getOrderedDate().get()) > 0) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                    else{

                        return-1;
                    }
                });

        List<Order> collect1 = sortedOrdersByDate.collect(Collectors.toList());
        collect1.forEach(System.out::println);
        //List<Product> collect1 = collect.stream().map(products -> products.get(0)).peek(System.out::println).collect(Collectors.toList());
        List<Order> orderEmptyList=new ArrayList<>();
        //List<Order> allOrderList2= List.of(order1,order2,order3,order4,order5,order6,order7,order8,order9,order10);
        Optional<Stream<Product>> productStream2 = Optional.of(orderEmptyList.stream().map(order -> order.getOrderedProducts()).flatMap(Collection::stream));

        OptionalDouble priceMax2=productStream2.get().mapToDouble(Product::getPrice).max();
        if (priceMax2.isPresent()) {
            System.out.println("priceMax2:" + priceMax2.getAsDouble());
        }
        else{
            System.out.println("priceMax2: not present");
        }



    }
}
