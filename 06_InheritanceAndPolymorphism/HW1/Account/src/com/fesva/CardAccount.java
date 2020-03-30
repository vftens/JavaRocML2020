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

    // который будет переводить деньги с счета на счет.
    public boolean transferTo(BankAccount bank, double amount) {
        super( bank, amount);
        /*
        if(withdraw(amount)){
            bank.deposit(amount);
            System.out.println("\nTransfer successful. Transfered: $" + amount);
            return true;
        }
        else {
            //does not need to be else if, because if not <=, it MUST be >.
            System.out.println("\nTransfer failed, not enough balance!");
        }
        return false;

         */
    }
}
