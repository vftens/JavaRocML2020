package com.fesva;

public class Individual extends com.fesva.Client {

    public Individual(String name) {
        super(name);
    }

    @Override
    public void withdraw(double amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
        }
    }

    @Override
    public void fund(double amount) {
        this.amount += amount;
    }
}
