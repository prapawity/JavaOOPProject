package com.company;

public interface Employee2 {
    public String getName();

    public void setName(String name);

    public String getPossition();

    public void setPossition(String possition);

    public double getSalary();

    public void setSalary(double salary);

    public void calSalary(int time, double salaryPerTime);
    public void showDetail();
}
