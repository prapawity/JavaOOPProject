package com.company;


public class Account {
    public double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public Account() {

    }
    public double getBalance(double v) {
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
    public double showBalance(){
        System.out.println(this.balance);
        return this.balance;
    }
}
