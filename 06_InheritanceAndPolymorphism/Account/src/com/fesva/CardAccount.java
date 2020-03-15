public class CardAccount extends BankAccount {
    public CardAccount() {
        super();
        comission = 0.01;
    }

    public CardAccount(double i) {
        super();
        comission = 0.01;
        super.deposit(i);
    }

    public boolean withdraw(double amount) {
        if (getBalance() - amount * (1 + getComission()) > 0) {
            return super.withdraw(amount * (1 + getComission()));
        }
        return false;
    }

    public double getComission() {
        return comission;
    }

    // при снятии денег с которого будет взиматься комиссия 1%.
    private volatile double comission;

}
