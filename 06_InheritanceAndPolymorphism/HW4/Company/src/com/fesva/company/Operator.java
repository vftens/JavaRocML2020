package com.fesva.company;

public class Operator extends Employee {

    public Operator(String ID, int salary, Company company) {
        super(ID, salary, company);
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

    @Override
    public String getMonthSalaryFormatted() {
        return String.format("%-10s: %10d руб.", getName(), getMonthSalary());
    }
}
