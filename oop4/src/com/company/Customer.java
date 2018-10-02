package com.company;

public class Customer {
    private String firstName, lastName;
    private Account acc = new Account();

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

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public static void main(String[] args) {
        Account myAccount = new CheckingAccount(4000, 500);
        Customer cus = new Customer("Somchai", "Somying");
        cus.setAcc(myAccount);
        cus.getAcc().withDraw(4300);
        cus.getAcc().showBalance();
        ((CheckingAccount)(cus.getAcc())).showCredit();
        cus.getAcc().deposite(4200);
        ((CheckingAccount)(cus.getAcc())).showCredit();
        System.out.println(cus.firstName+" "+cus.lastName);
    }
}
