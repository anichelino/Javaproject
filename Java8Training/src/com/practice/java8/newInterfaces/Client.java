package com.practice.java8.newInterfaces;

import com.practice.java8.functionalinterfaces.bankApplication.BankAccount;

import java.util.function.Function;
import java.util.function.Supplier;

public class Client implements BankClientRegistration {
    private String name;
    private String surname;
    private String bankPlace;


    private com.practice.java8.functionalinterfaces.bankApplication.BankAccount bankAccount;

    private boolean isDocumentsUploaded;

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
        BankClientRegistration.welcomeMessage();
    }
    public Client(String name, String surname, String bankPlace) {
        this.name = name;
        this.surname = surname;
        this.bankPlace=bankPlace;
        BankClientRegistration.welcomeMessage();
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bankAccount=" + bankAccount +
                ", isDocumentsUploaded=" + isDocumentsUploaded +
                '}';
    }

    public double getBalance(Function<Client,Double> clientBalanceFunction){

       return clientBalanceFunction.apply(this);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public com.practice.java8.functionalinterfaces.bankApplication.BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public boolean isDocumentsUploaded() {
        return isDocumentsUploaded;
    }

    public void setDocumentsUploaded(boolean documentsUploaded) {
        isDocumentsUploaded = documentsUploaded;
    }

    @Override
    public long bankAccountRegistration(Supplier<Long> clientSupplier) {

        return Math.abs(clientSupplier.get());
    }

    @Override
    public String bankFilial() {
        if (!this.bankPlace.isEmpty()){
            return this.bankPlace;
        }
        else {
            return this.bankFilial();
        }

    }
}
