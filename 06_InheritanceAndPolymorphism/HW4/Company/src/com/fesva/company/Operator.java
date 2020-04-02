package com.fesva.company;

public class Operator extends Employee {

    public Operator(String ID, int salary, Company company) {
        super(ID, salary, company);
    }

    public Operator(int i) {
        super(i);
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

    @Override
    public String printMonthSalary() {
        return String.format("%-10s: %10d", getName(), getMonthSalary());
    }

}
