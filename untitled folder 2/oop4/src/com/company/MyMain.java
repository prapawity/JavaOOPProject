package com.company;

public class MyMain {
    public static void main(String[] args){
        CheckingAccount acc = new CheckingAccount(2000, 500);
        acc.deposite(200);
        acc.showBalance();
        acc.withDraw(6000);
        acc.withDraw(5000);
        acc.showBalance();
    }
}
