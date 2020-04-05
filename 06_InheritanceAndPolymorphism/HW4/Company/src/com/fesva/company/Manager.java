package com.fesva.company;

public class Manager extends Employee {

    private final static double BONUS_PERCENT = 0.05;
    private int monthProceeds = 0;

    public Manager(String ID, int salary, Company company) {
        super(ID, salary, company);
    }

    @Override
    public int getMonthSalary() {
        return salary + bonusValue;
    }

    @Override
    public String getMonthSalaryFormatted() {
        return String.format("%-10s: %10d руб. (salary: %d руб., bonus: %d руб. )", getName(), getMonthSalary(), salary, bonusValue);
    }

    @Override
    public int gainMoney() {
        monthProceeds = (int)Math.round(Math.random() * 400000);
        return monthProceeds;
    }

    @Override
    public void countBonus() {
        bonusValue = (int)Math.round(monthProceeds * BONUS_PERCENT);
    }
}
