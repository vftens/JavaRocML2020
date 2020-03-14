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

    public void withdraw(double amount) {
        super.withdraw(amount * (1 + getComission()));
    }

    public double getComission() {
        return comission;
    }

    public void setComission(double comission) {
        this.comission = comission;
    }

    // при снятии денег с которого будет взиматься комиссия 1%.
    private volatile double comission;

}
