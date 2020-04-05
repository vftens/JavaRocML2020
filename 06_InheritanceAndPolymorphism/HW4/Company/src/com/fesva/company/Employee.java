package com.fesva.company;

public abstract class Employee {

    private final String ID;
    private final String name;
    protected int salary;

    protected Company company;

    public Employee(String ID, int salary, Company company) {
        this.ID = ID;
        this.salary = salary;
        this.company = company;
        this.name = ID;
    }

    public abstract int getMonthSalary();

    public abstract String getMonthSalaryFormatted();

    public int gainMoney() {
        return 0;
    }

    public void countBonus() {
    }

    public String getName() {
        return this.ID;
    }
}