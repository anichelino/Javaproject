package com.practice.java8.newInterfaces;

import com.practice.java8.functionalinterfaces.bankApplication.BankAccount;
import com.practice.java8.functionalinterfaces.bankApplication.methodReference.Client;

import java.util.function.Consumer;

public interface BankOperations {
    BankAccount bankAccount= new BankAccount(0.0);

    void deposit(Double amount, Consumer<String> errorCallback, Consumer<Double> successCallback);
    void withdraw( Double amount, Consumer<String> errorCallback,Consumer<Double> successCallback);

    default Double getBalance() {
        return bankAccount.getBalance();
    };

    static void welcomeMessage(){
        System.out.println("Welcome to our banking application");
    }

}
