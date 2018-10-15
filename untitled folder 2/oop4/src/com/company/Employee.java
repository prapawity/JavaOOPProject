package com.company;

public class Employee {
    protected String name;
    protected String possition;
    protected double salary;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPossition() {
        return possition;
    }

    public void setPossition(String possition) {
        this.possition = possition;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void calSalary(int time, double salaryPerTime){
        salary = time*salaryPerTime;
    }
    public void showDetail(){
        System.out.println(name+possition+salary);
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Name");
        employee.setPossition("Manager");
        employee.setSalary(600.00);
        employee.calSalary(20,20);
        employee.showDetail();
    }
}
