package com.practice.java8.functionalinterfaces.bankApplication.methodReference;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class BankAccount {
    private Double balance;
    private long bankAccountNumber;

    public BankAccount(Double balance) {
        this.balance = balance;
    }

    public void deposit(Double amount, Consumer<String> errorCallback,Consumer<Double> successCallback){
        if (amount<=0){
            errorCallback.accept("amount to deposit is less than zero");
            return;
        }
        this.balance=this.balance+amount;
        successCallback.accept(balance);
    }


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
    public void verify(Client client, Predicate<Client> clientPredicate, Consumer<String> callback, BiConsumer<Client,String> clientConsumerVerifiedCallback, Consumer<Client> clientConsumerNotVerifiedCallback){
        if (clientPredicate.test(client)){
            callback.accept("account of "+client.getName()+" is verified");
            clientConsumerVerifiedCallback.accept(client,"V "+client.getName());
        }
        if (!clientPredicate.test(client)){
            callback.accept("account of "+client.getName()+" is not verified");
            clientConsumerNotVerifiedCallback.accept(client);
        }
    }
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