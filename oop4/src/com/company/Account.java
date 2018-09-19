package com.company;


public class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void deposite(double deposite){
        balance = balance+deposite;
    }
    public void withDraw(double withDraw){
        if (withDraw>balance)
            System.out.println("Money is noy Enough");
        else
            balance -= withDraw;
    }
    public void showBalance(){
        System.out.println(balance);
    }
}
