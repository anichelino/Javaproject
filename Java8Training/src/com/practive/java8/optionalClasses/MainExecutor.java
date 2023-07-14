package com.practive.java8.optionalClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class MainExecutor {

    public static void main(String[] args) {

        BankAccount bankAccount= new BankAccount(1000.0);
        BankAccount bankAccount2= new BankAccount(2000.0);
        BankAccount bankAccount3= new BankAccount(3000.0);
        //long accountNumber = new Random().nextLong();
        Client client1=new Client("John","Doe",bankAccount,true,   ()->new Random().nextLong());
        Client client2=new Client("Jack","Murphill",bankAccount2,true,    ()->new Random().nextLong());
        Client client3=null;

        Optional<Client> clientOptional=Optional.of(client1);
        System.out.println(clientOptional.get().getName());
        Optional<Client> clientOptional1_1=Optional.of(client3);
        System.out.println(clientOptional1_1.orElse(client2));

        Optional<Client> clientOptional2=Optional.ofNullable(client1);
        System.out.println(clientOptional2);
        Optional<Client> clientOptional3=Optional.ofNullable(client3);
        System.out.println(clientOptional3);

        Optional<Client> clientOptional4=Optional.ofNullable(client1);
        System.out.println(clientOptional4);

        Client clientOptional6=Optional.ofNullable(client3).orElse(client2);
        System.out.println(clientOptional6);

        boolean isPresentClient=clientOptional3.isPresent();
        System.out.println(isPresentClient);


        client3.getName();

    }

}
