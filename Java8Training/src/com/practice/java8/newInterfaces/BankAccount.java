package com.practice.java8.newInterfaces;

import com.practice.java8.functionalinterfaces.bankApplication.Client;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class BankAccount implements BankOperations{
    private Double balance;
    private long bankAccountNumber;

    public BankAccount(Double balance) {
        this.balance = balance;
        BankOperations.welcomeMessage();
    }
  //  @Override
    /*    public void welcomeMessage(){
        System.out.println("Welcome to our banking application");
    //}*/

    @Override
    public void deposit(Double amount, Consumer<String> errorCallback,Consumer<Double> successCallback){
        if (amount<=0){
            errorCallback.accept("amount to deposit is less than zero");
            return;
        }
        this.balance=this.balance+amount;
        successCallback.accept(balance);
    }


    @Override
    public void withdraw(Double amount, Consumer<String> errorCallback,Consumer<Double> successCallback){
        if (amount<=0){
            errorCallback.accept("amount to withdraw is less than zero,balance is always "+this.balance+"$ ");
            return;
        }
        if (amount>balance){
            errorCallback.accept("amount too high, no sufficient balance");
            return;
        }
        this.balance=this.balance-amount;
        successCallback.accept(balance);
    }
    public void verify(Client client, Predicate<Client> clientPredicate, Consumer<String> callback, Consumer<Client> clientConsumerVerifiedCallback, Consumer<Client> clientConsumerNotVerifiedCallback){
        if (clientPredicate.test(client)){
            callback.accept("account of "+client.getName()+" is verified");
            clientConsumerVerifiedCallback.accept(client);
        }
        if (!clientPredicate.test(client)){
            callback.accept("account of "+client.getName()+" is not verified");
            clientConsumerNotVerifiedCallback.accept(client);
        }
    }
    @Override
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public long getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(long bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", bankAccountNumber=" + bankAccountNumber +
                '}';
    }
}