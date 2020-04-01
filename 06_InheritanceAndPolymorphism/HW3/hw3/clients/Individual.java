package com.fesva.clients;

public class Individual extends Client {

    public Individual(String name) {
        super(name);
    }

    @Override
    public void withdrow(double amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
        }
    }

    @Override
    public void fund(double amount) {
        this.amount += amount;
    }
}
