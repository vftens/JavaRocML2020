
public class Main {

    public static void main(String[] args) {
        // write your code here

        DepositaryAccount depAcc;
        depAcc = new DepositaryAccount(120);
        depAcc.deposit(180);

        if (depAcc.withdraw(110)){
            System.out.println("Withdraw sucessful ");
        } else {
            System.out.println("Withdraw denied ");
        }

        System.out.println("Баланс Депозитарный: " + depAcc.getBalance());

        CardAccount acc;
        acc = new CardAccount(100);
        acc.deposit(200);
        if (acc.withdraw(50)){
            System.out.println("Withdraw allowed.");
        }
        else {
            System.out.println("Withdraw denied.");
        }
        System.out.println("Итоговый баланс: " + acc.getBalance());

        CardAccount creditCard = new CardAccount(100);
        DepositaryAccount deposit = new DepositaryAccount(100);

        if(deposit.transferTo(creditCard,
                50) ) {
            System.out.println("Success !");
        }
        else {
            System.out.println("Failed !"); // не должно пройти, т.к. не прошел месяц.
        }
        if(creditCard.transferTo(deposit, 50) ) {
            System.out.println("Success !");
        }
        else {
            System.out.println("Failed !"); // не должно пройти, т.к. не прошел месяц.
        }; // всё должно ОК

        CardAccount card = new CardAccount(100);
        if(card.transferTo(deposit, 1) ) {
            System.out.println("Success !");
        }
        else {
            System.out.println("Failed !"); // не должно пройти, т.к. не прошел месяц.
        };
        if(card.transferTo(card, 1) ) {
            System.out.println("Success !");
        }
        else {
            System.out.println("Failed !"); // не должно пройти, т.к. не прошел месяц.
        };

        DepositaryAccount  d = new DepositaryAccount(120);

        d.deposit(100);
        // "подкрутим" дату на 5 месяцев назад
        d.dateOp = d.dateOp.minusMonths(5);
        // можно снимать
        boolean isSuccess = d.withdraw(150);
        System.out.println("Transfer Successful after 5 Months - " + isSuccess);
    }
}
