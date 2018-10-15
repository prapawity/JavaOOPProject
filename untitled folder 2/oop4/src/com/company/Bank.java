package com.company;

public class Bank {
    private Account acct[];
    private int numAcct;

    public Bank() {
        Account[] acct = new Account[10];
    }
    public void addAccount(Account ac){
        acct[numAcct] = ac;
        numAcct++;
    }
    public Account getAcct(int index) {
        return acct[index];
    }

    public void setAcct(Account[] acct) {
        this.acct = acct;
    }

    public int getNumAcct() {
        return numAcct;
    }

    public void setNumAcct(int numAcct) {
        this.numAcct = numAcct;
    }
}
