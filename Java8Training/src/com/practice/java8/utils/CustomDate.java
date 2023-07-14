package com.practice.java8.utils;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.function.Supplier;

public class CustomDate {
    int year;
    int month;
    int day;
    Supplier<Date> dateSupplier;

    public CustomDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public Date toDate(){

        this.dateSupplier= ()->new GregorianCalendar(this.year,(this.month-1),this.day).getTime();
        return this.dateSupplier.get();
    }
}
