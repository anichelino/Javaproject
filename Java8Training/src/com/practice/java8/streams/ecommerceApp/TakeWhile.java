package com.practice.java8.streams.ecommerceApp;
/* Realtime Example of takeWhile*/

  import java.util.ArrayList;
  import java.util.List;
  import java.util.stream.Stream;

public class TakeWhile {
    public static void main(String[] args) {
        List<Double> stockPrices = new ArrayList<>();
        stockPrices.add(100.5);
        stockPrices.add(102.3);
        stockPrices.add(99.8);
        stockPrices.add(101.2);
        stockPrices.add(105.7);
        stockPrices.add(107.9);

        // Create a stream from the stock prices list
        Stream<Double> priceStream = stockPrices.stream();

        // Define the threshold price
        double thresholdPrice = 102.0;

        // Use takeWhile to capture prices until the threshold is reached
        Stream<Double> filteredStream = priceStream.dropWhile(price -> price <= thresholdPrice);

        // Perform further actions on the filtered stream
        filteredStream.forEach(System.out::println);

        // Additional actions can be performed here, such as sending a notification or initiating a trade
        System.out.println("Threshold reached. Further actions can be performed.");
        Stream<Integer> evenNumbers = Stream.iterate(2,n->n<=10,n->n+2);
        evenNumbers.forEach(System.out::println);

        String name = null;
        Stream<String> nameStream = Stream.ofNullable(name);



        if (nameStream.findAny().isPresent()){

        nameStream.forEach(System.out::println);
        }
        else
        {
            System.out.println("empty stream");
        }




        String nullName = null;
        Stream<String> nullNameStream = Stream.ofNullable(nullName);



        nullNameStream.forEach(System.out::println);
    }
}