package com.fesva;

public class Main {
    public static void main(String[] args) {

        Client vasya = new Individual("Вася Пупкин");
        Client business = new Legal("ООО \"Рога и копыта\"");
        Client ip = new Entrepreneur("Пётр Иванович Блатных");

        System.out.println("Initial values");
        printAccAmounts(vasya, business, ip);

        System.out.println("\n--- Fund 100 ---");
        vasya.fund(100);
        business.fund(100);
        ip.fund(100);
        printAccAmounts(vasya, business, ip);

        System.out.println("\n--- Fund 1000 ---");
        vasya.fund(1000);
        business.fund(1000);
        ip.fund(1000);
        printAccAmounts(vasya, business, ip);

        System.out.println("\n--- Withdraw 10 ---");
        vasya.withdraw(10);
        business.withdraw(10);
        ip.withdraw(10);
        printAccAmounts(vasya, business, ip);

    }

    private static void printAccAmounts(Client... clients) {
        System.out.println("\n\nAvailable money, rub");
        for (Client client :
                clients) {
            System.out.println(client.getDepositString());
        }
    }
}
