package com.practice.java8.streams.ecommerceApp;

import com.practice.java8.utils.CustomDate;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.DoubleStream.builder;

public class MainExecutor3 {
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
        Order order1= new Order(order1Products,1, Optional.empty());
        Order order2= new Order(order2Products,2,Optional.of(new CustomDate(2023,2,2).toDate()));
        Order order3= new Order(order3Products,3,Optional.of(new CustomDate(2012,2,2).toDate()));
        Order order4= new Order(order4Products,4,Optional.of(new CustomDate(2013,2,2).toDate()));
        Order order5= new Order(order5Products,5,Optional.of(new CustomDate(2004,2,2).toDate()));
        Order order6= new Order(allproductsList,6,Optional.of(new CustomDate(2005,2,2).toDate()));
        Order order7= new Order(order7Products,7,Optional.of(new CustomDate(2006,2,2).toDate()));
        Order order8= new Order(order8Products,8,Optional.of(new CustomDate(2009,2,2).toDate()));
        Order order9= new Order(order9Products,9,Optional.of(new CustomDate(2010,2,2).toDate()));
        Order order10= new Order(order10Products,10,Optional.of(new CustomDate(2014,2,2).toDate()));
        List<Order> allOrderList= List.of(order1,order2,order3,order4,order5,order6,order7,order8,order9,order10);


        Stream<String> collect = allOrderList.stream().map(order->order.getOrderedProducts()).flatMap(products -> products.stream()).map(product -> product.getName()).peek(System.out::println);
        //Stream<String> collect2 = allOrderList.stream().map(order->order.getOrderedProducts()).flatMap(products -> products.stream()).map(product -> product.getName()).peek(System.out::println);
        Stream<Product> collectOnlyProducts = allOrderList.stream().map(order->order.getOrderedProducts()).flatMap(products -> products.stream());

        Stream<Product> collectOnlyProducts2 = allOrderList.stream().map(order->order.getOrderedProducts()).flatMap(products -> products.stream());
        Stream<Product> collectOnlyProducts3 = allOrderList.stream().map(order->order.getOrderedProducts()).flatMap(products -> products.stream());
        Stream<Product> collectOnlyProducts4 = allOrderList.stream().map(order->order.getOrderedProducts()).flatMap(products -> products.stream()).filter(product -> product.getType()==
                "Household");
        //collectOnlyProducts4.forEach(System.out::println);

        Optional<Product> any = collectOnlyProducts.filter(product -> product.getType()=="Household").findAny();



        if (any.isPresent()){
            System.out.println(any.get());
        }
        else{
            System.out.println("element not present");
        }


        boolean b = collectOnlyProducts2.allMatch(product -> product.getType() == "Household");
        System.out.println(b);
        boolean b1 = collectOnlyProducts3.anyMatch(product -> product.getType() == "Household");
        System.out.println(b1);
        //order streams in alphabetical order
        Stream<String> stringStream=Stream.of("angela","lorena","nicola","luigia","susanna");
        stringStream.sorted().forEach(System.out::println);


        Stream<Integer> infiniteEvenNumbers = Stream.iterate(0, n-> n+2).limit(10);
        List<Integer> collect1 = infiniteEvenNumbers.takeWhile(n -> n < 3).collect(Collectors.toList());
        collect1.forEach(System.out::println);
        System.out.println("!!!!!!!!!!!!!!!!!! after take while");


        Stream.Builder<String> builder = Stream.builder();
        Stream<String> stringStream1 = builder.add("a").add("b").build();
        stringStream1.forEach(System.out::println);

        Map<String,Integer> map= new HashMap<>();

        map.put("age",60);
        map.put("age",60);
        map.put("years of work",40);
        map.put("mom age",80);
        map.put("father age",85);
        map.put("first son age",35);
        map.put("second son age",30);

        map.forEach((key,value)-> System.out.println(key+" "+value));

        System.out.println("---------------------------");
        Stream<Map.Entry<String,Integer>> entryStream= map.entrySet().stream();
        entryStream.filter((entry)->entry.getValue()>60).forEach(System.out::println);
       // entryStream.forEach(System.out::println);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
                .takeWhile(num -> num % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers);


    }
}
