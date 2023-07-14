package com.practice.java8.newInterfaces;

import java.util.function.Supplier;

@FunctionalInterface
public interface BankClientRegistration {

    long bankAccountRegistration(Supplier<Long> clientSupplier);
    default String bankFilial(){
        return "Rome";
    }
    static void welcomeMessage(){
        System.out.println("Welcome to client registration");
    }
}
