package com.practice.interview.barclays;

import java.util.*;
import java.util.stream.Stream;

public class MainExeutor_Interview {
    public static void main(String[] args) {

        int n=10;
        //Create a method that fills an array with integers from 1 to n (or use upperLimit as argument for the last upper number)
        Stream<Integer> integerStream = Stream.iterate(1,i->i+1).limit(n);
        int[] example2 = integerStream.mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < example2.length; i++) {
            System.out.println(example2[i]);
        }





        //for the 2nd party
        //create a method/functionality to Randomize the order of the elements inside the array (you can do it by randomly switch 2 numbers in the array at a time)
        Integer[] integers= new Integer[n];
        for (int i = 0; i <integers.length ; i++) {
            integers[i]=Integer.valueOf(example2[i]);
        }
        List<Integer> listInteger= Arrays.asList(integers);
        System.out.println(listInteger);
        for (int i = 0; i <n ; i++) {

            int j= new Random().nextInt(n);
        Collections.swap(listInteger,i,j);
        }
        System.out.println("---------");
        System.out.println(listInteger);


    }
}
