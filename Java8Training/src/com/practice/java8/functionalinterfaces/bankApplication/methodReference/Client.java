package com.practice.java8.functionalinterfaces.bankApplication.methodReference;

import java.util.function.Function;
import java.util.function.Supplier;

public class Client {
    private String name;
    private String surname;

    private BankAccount bankAccount;

    private boolean isDocumentsUploaded;

    public Client(String name, String surname, BankAccount bankAccount, boolean isDocumentsUploaded, Supplier<Long>longSupplier) {
        this.name = name;
        this.surname = surname;
        this.bankAccount = bankAccount;
        this.isDocumentsUploaded = isDocumentsUploaded;
        this.bankAccount.setBankAccountNumber(Math.abs(longSupplier.get()));
        System.out.println(this);
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

    public double getBalance(Function<BankAccount,Double> clientBalanceFunction){

       return clientBalanceFunction.apply(this.bankAccount);

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

    public BankAccount getBankAccount() {
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
}
