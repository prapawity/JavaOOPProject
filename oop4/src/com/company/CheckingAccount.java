package com.company;

public class CheckingAccount extends Account {
    private double credit = 0;

    public CheckingAccount(double balance, double credit) {
        super(balance);
        this.credit = credit;
    }

    @Override
    public void withDraw(double withDraw) {
        if (balance<withDraw && credit<=0)
            System.out.println("Money and credit is not  enough");
        else
            balance -= withDraw;

    }
    public void showCredit(){
        System.out.println(credit);
    }
}