package com.fesva.company;

public abstract class Employee {

    private final String ID;
    protected int salary;
    protected int bonusValue = 0;

    protected Company company;

    public Employee(String ID, int salary, Company company) {
        this.ID = ID;
        this.salary = salary;
        this.company = company;
    }

    public Employee(int i) {

        ID = null;
    }

    public abstract int getMonthSalary();
    public abstract String printMonthSalary();

    public int gainMoney() {
        return 0;
    }

    public void countBonus() {}
    public String getID() {
        return ID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonusValue() {
        return bonusValue;
    }

    public void setBonusValue(int bonusValue) {
        this.bonusValue = bonusValue;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }



    public String getName() {
        return this.ID;
    }
}