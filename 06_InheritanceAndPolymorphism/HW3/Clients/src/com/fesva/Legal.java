package com.fesva;

public class Legal extends Client {

    private static double WITHDRAW_TAXES = 0.01;

    public Legal(String name) {
        super(name);
    }

    @Override
    public void withdraw(double amount) {

        amount += amount * WITHDRAW_TAXES;

        if (this.amount >= amount) {
            this.amount -= amount;
        }
    }

    @Override
    public void fund(double amount) {
        this.amount += amount;
    }
}
