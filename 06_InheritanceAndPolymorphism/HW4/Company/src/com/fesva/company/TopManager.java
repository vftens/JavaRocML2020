package com.fesva.company;

public class TopManager extends Employee {

    public TopManager(String ID, int salary, Company company) {
        super(ID, salary, company);
    }

    public TopManager(int i) {
        super(i);
    }

    @Override
    public int getMonthSalary() {
        return salary + bonusValue;
    }

    @Override
    public String printMonthSalary() {
        return String.format("%-10s: %10d (salary: %d, bonus: %d)", getName(), getMonthSalary(), salary, bonusValue);
    }

    @Override
    public void countBonus() {
        bonusValue = company.isCompanyGoalAchieved() ? (int)Math.round(salary * 1.5) : 0;
    }
}
