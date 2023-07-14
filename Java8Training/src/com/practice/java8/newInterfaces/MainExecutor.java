package com.practice.java8.newInterfaces;

import java.util.Random;

public class MainExecutor {
    public static void main(String[] args) {

        BankAccount bankAccount= new BankAccount(100.0);
        System.out.println(bankAccount.getBalance());
        Client client=new Client("Satish","Panaganti");
        System.out.println(client.bankAccountRegistration(new Random()::nextLong));

    }

}
