package com.company;

import java.util.ArrayList;

public class Customer {
    private String firstName, lastName;
    private Account acc[] = new Account[5];
    private ArrayList acct = new ArrayList();
    public ArrayList<Account> getAcct() {
        return acct;
    }

    public void setAcct(ArrayList acct) {
        this.acct = acct;
    }

    public void setNumOfAccount(int numOfAccount) {
        this.numOfAccount = numOfAccount;
    }

    private int numOfAccount;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Account getAcc(int index) {
        return acc[index];
    }

    public int getNumOfAccount() {
        return numOfAccount;
    }

    public void addaccount(Account ac){
        acc[numOfAccount] = ac;
        numOfAccount++;
    }

    public void setAcc(Account[] acc) {
        this.acc = acc;
    }

    public static void main(String[] args) {
        Customer cus = new Customer("Somchai", "Somying");
        Account acct1 = new Account(5000);
        Account acct2 = new Account(3000);
        cus.addaccount(acct1);
        cus.addaccount(acct2);
        acct1.deposite(100);
        acct1.showBalance();
        acct2.deposite(1000);
        acct2.showBalance();


    }
}
