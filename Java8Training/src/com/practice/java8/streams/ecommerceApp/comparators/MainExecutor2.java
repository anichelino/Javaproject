package com.practice.java8.streams.ecommerceApp.comparators;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MainExecutor2 {
    public static void main(String[] args) {

        Product product1= new Product("toothbrush",1,"household",2.34) ;
        Product product2= new Product("Multimeter",2,"Electricalhold",22.34) ;
        Product product3= new Product("shoes",3,"Personalstuff",200.34) ;
        Product product4= new Product("Notebook",4,"Personalstuff",2000.34) ;
        Product product5= new Product("T-shirt",5,"Personalstuff",22000.14) ;
        Product product6= new Product("Subwoofer",6,"household",122.34) ;
        Product product7= new Product("Headphones",7,"Personalstuff",322.34) ;
        Product product8= new Product("VoltageSupplier",8,"Electricalhold",2.34) ;
        Product product9= new Product("Chair",9,"Household",52.34) ;
        Product product10= new Product("Shelves",10,"Household",182.34) ;
        //Product product11= new Product("Shelves",10,"Household",10.90) ;
        Product product11= null;
        List<Product> allproductsList= List.of(product1,product2,product3,product4,product5,product6,product7,product8,product9,product10);
        List<Product> order1Products= new ArrayList<>(List.of(product6, product7, product1));

        List<Product> order2Products=List.of(product2,product3,product4,product5);
        List<Product> order3Products=List.of(product5,product6,product7,product8,product9);
        List<Product> order4Products=new ArrayList<>(List.of(product1,product6,product7,product10,product2));
        List<Product> order5Products=List.of(product1,product6,product7,product4,product5);
        List<Product> order7Products=List.of(product2,product6,product7,product4,product10);
        List<Product> order8Products=List.of(product3,product6,product8,product4,product10);
        List<Product> order9Products=List.of(product10,product6,product9,product8,product2);
        List<Product> order10Products=List.of(product9,product6,product1,product7,product2);
       // Order order1= new Order(order1Products,1,new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime());
        Order order1= new Order(order1Products,1,Optional.of(LocalDate.of(2023,2,11)));
        Order order2= new Order(order2Products,2,Optional.of(LocalDate.of(2023,2,11)));
        Order order3= new Order(order3Products,3,Optional.of(LocalDate.of(2012,2,11)));
        Order order4= new Order(order4Products,4,Optional.of(LocalDate.of(2013,2,11)));
        Order order5= new Order(order5Products,5,Optional.of(LocalDate.of(2004,2,11)));
        Order order6= new Order(allproductsList,6,Optional.of(LocalDate.of(2005,2,11)));
        Order order7= new Order(order7Products,7,Optional.of(LocalDate.of(2006,2,11)));
        Order order8= new Order(order8Products,8,Optional.of(LocalDate.of(2009,2,11)));
        Order order9= new Order(order9Products,9,Optional.of(LocalDate.of(2010,2,11)));
        Order order10= new Order(order10Products,10,Optional.of(LocalDate.of(2014,2,11)));
        List<Order> allOrderList= List.of(order1,order2,order3,order4,order5,order6,order7,order8,order9,order10);
        List<Order> allOrderList2= new ArrayList<>(List.of(order1,order2,order3,order4,order5,order6,order7,order8,order9,order10));
        List<Optional<Product>> orderNullProducts= new ArrayList<>(List.of(Optional.ofNullable(product6), Optional.ofNullable(product7), Optional.ofNullable(product1),Optional.ofNullable(product11)));

        System.out.println("------------------------------------ ");
        order1Products.sort(Comparator.comparing(Product::getPrice).reversed());
        order1Products.forEach(System.out::println);
        String collect = order2Products.stream().map(Product::getName).collect(Collectors.joining(", ", "[ ", " ]"));
        System.out.println(collect);
        Comparator<Product> productComparatorByType= Comparator.comparing(Product::getType);
        Comparator<Product> productComparatorById= Comparator.comparing(Product::getId);
        System.out.println("------------------------------------ ");

        order4Products.sort(productComparatorByType.thenComparing(productComparatorById));
        order4Products.forEach(System.out::println);
        Comparator<Product> productComparatorByPrice= Comparator.comparing(Product::getPrice);
        System.out.println("------------------------------------ ");
        Comparator<Product> productComparatorByTypeCaseInsensitive= (p1,p2)->p1.getType().compareToIgnoreCase(p2.getType());
        order4Products.sort(productComparatorByTypeCaseInsensitive);
        order4Products.forEach(System.out::println);
        Comparator<Optional<Product>> optionalComparator = (p1,p2)->{
          if (p1.isPresent() && p2.isPresent()){
            return Double.compare(p1.get().getPrice(),p2.get().getPrice());
          }
          else{
              return 0;
          }
        };
        Comparator<Optional<LocalDate>> optionalDateComparator = (p1,p2)->{
            if (p1.isPresent() && p2.isPresent()){
                return p1.get().compareTo(p2.get());
            }
            else{
                return 0;
            }
        };
        System.out.println("------------------------------------ ");

        orderNullProducts.sort(optionalComparator);
        orderNullProducts.forEach(System.out::println);
        System.out.println("------------------------------------ ");

        allOrderList2.sort(Comparator.comparing(o->
        o.getOrderedDate().get()));
        allOrderList2.forEach(System.out::println);









    }
}
