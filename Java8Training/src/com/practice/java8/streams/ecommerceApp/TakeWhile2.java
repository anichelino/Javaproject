package com.practice.java8.streams.ecommerceApp;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class TakeWhile2 {
    public static void main(String[] args) {
        List<Double> stockPrices = new ArrayList<>();
        stockPrices.add(100.0);
        stockPrices.add(100.3);
        stockPrices.add(100.8);
        stockPrices.add(101.2);
        stockPrices.add(105.7);
        stockPrices.add(107.9);
        stockPrices.add(97.9);
        stockPrices.add(98.9);

        // Create a stream from the stock prices list
        Stream<Double> priceStream = stockPrices.stream();
        Stream<Double> priceStream2 = stockPrices.stream();
        Stream<Double> priceStream3 = stockPrices.stream();
        Stream<Double> priceStream4 = stockPrices.stream();
        Stream<Double> priceStream5 = stockPrices.stream();
        System.out.println("-----------------------");

        //priceStream.mapToDouble(d->d).takeWhile((prev,next)->next>prev);
        priceStream.takeWhile(n->n<101).forEach(System.out::println);
        System.out.println("-----------------------");
        priceStream2.dropWhile(n->n<101).forEach(System.out::println);

        OptionalDouble average = priceStream3.mapToDouble(d -> d).average();
        System.out.println("-----------------------");
        if (average.isPresent()){
            System.out.println("stock average: "+average.getAsDouble());

        System.out.println("-----------------------");
        priceStream4.takeWhile(n->n<average.getAsDouble()).forEach(System.out::println);
        System.out.println("-----------------------");


        priceStream5.dropWhile(n->n<average.getAsDouble()).forEach(System.out::println);
        }



    }
}
