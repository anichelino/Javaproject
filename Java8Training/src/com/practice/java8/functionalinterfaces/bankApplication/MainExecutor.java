package com.practice.java8.functionalinterfaces.bankApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainExecutor {

    public static void main(String[] args) {

        BankAccount bankAccount= new BankAccount(1000.0);
        BankAccount bankAccount2= new BankAccount(2000.0);
        BankAccount bankAccount3= new BankAccount(3000.0);
        //long accountNumber = new Random().nextLong();
        Client client1=new Client("John","Doe",bankAccount,true,   ()->new Random().nextLong());
        Client client2=new Client("Jack","Murphill",bankAccount2,true,    ()->new Random().nextLong());
        Client client3=new Client("Luke","Leiman",bankAccount3,false,    ()->new Random().nextLong());
        bankAccount.deposit(0.0, System.out::println, (b)-> System.out.println("deposit accepted, new balance is : "+b+" $"));
        bankAccount.withdraw(0.0, System.out::println, (b)-> System.out.println("withdraw accepted, new balance is : "+b+" $"));
        bankAccount.verify(client1,(c)-> c.isDocumentsUploaded(), System.out::println,(c)->c.setName("V "+c.getName()),(c)->c.setName("NV "+c.getName()));
        bankAccount.verify(client2,(c)-> c.isDocumentsUploaded(), System.out::println,(c)->c.setName("V "+c.getName()),(c)->c.setName("NV "+c.getName()));
        bankAccount.verify(client3,(c)-> c.isDocumentsUploaded(), System.out::println,(c)->c.setName("V "+c.getName()),(c)->c.setName("NV "+c.getName()));
        System.out.println(client1);
        System.out.println(client2);
        System.out.println(client3);
        List<Client> clientList=new ArrayList<>();
        clientList.add(client1);
        clientList.add(client2);
        clientList.add(client3);
        System.out.println("Client balance "+client1.getBalance((c)->c.getBankAccount().getBalance())+" $");
        System.out.println("Client2 balance "+client2.getBalance((c)->c.getBankAccount().getBalance())+" $");
        System.out.println("Client3 balance "+client3.getBalance((c)->c.getBankAccount().getBalance())+" $");

    }

}
