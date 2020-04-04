package com.fesva.company;

public class TopManager extends Employee {
    private static final int PERCENT = 150;

    public TopManager(String ID, int salary, Company company) {
        super(ID, salary, company);
    }

    @Override
    public int getMonthSalary() {
        return salary + bonusValue;
    }

    @Override
    public String printMonthSalary() {
        return String.format("%-10s: %10d руб. (salary: %d руб., bonus: %d руб. )", getName(), getMonthSalary(), salary, bonusValue);
    }

    @Override
    public void countBonus() {
        bonusValue = company.isCompanyGoalAchieved() ? (int) Math.round(salary * PERCENT / 100) : 0;
    }
}
