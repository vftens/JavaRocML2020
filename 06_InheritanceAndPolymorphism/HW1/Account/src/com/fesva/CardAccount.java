public class CardAccount extends BankAccount {
    // при снятии денег с которого будет взиматься комиссия 1%.
    private static final double COMISSION = 0.01;

    public CardAccount() {

    }

    public CardAccount(double amount) {
        super();
        super.deposit(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        if (getBalance() - amount * (1 + COMISSION) > 0) {
            return super.withdraw(amount * (1 + COMISSION));
        }
        return false;
    }
}
