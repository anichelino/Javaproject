package com.practice.interview.barclays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Requirements {

    public static int[] initializeAnArray(int n){

        //Create a method that fills an array with integers from 1 to n (or use upperLimit as argument for the last upper number)


        int[] integers = new int[n];


        for (int i = 0; i < n; i++) {
            integers[i]= i+1;
        }


        return integers;

    }
    public static int[] shuffleAnArray(int[] arrayToShuffle){


        for (int i = 0; i < arrayToShuffle.length; i++) {
            int j= new Random().nextInt(arrayToShuffle.length);

            int[] tempArray = new int[arrayToShuffle.length];
            tempArray[i]=arrayToShuffle[i];
            arrayToShuffle[i]=arrayToShuffle[j];
            arrayToShuffle[j]=tempArray[i];

        }
        return arrayToShuffle;

    }
}
