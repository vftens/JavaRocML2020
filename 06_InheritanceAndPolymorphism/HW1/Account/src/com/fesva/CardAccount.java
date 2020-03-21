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
    public void transferTo(BankAccount bank, double amount) {
        if(withdraw(amount)){
            bank.deposit(amount);
            System.out.println("\nTransfer successful. Transfered: $" + amount);
        }
        else {
            //does not need to be else if, because if not <=, it MUST be >.
            System.out.println("\nTransfer failed, not enough balance!");
        }

    }

    public void transferTo(DepositaryAccount bank, double amount) {
        if(this.withdraw(amount)){
            bank.deposit(amount);
            System.out.println("\nTransfer C successful. Transfered: $" + amount);
        }
        else {
            //does not need to be else if, because if not <=, it MUST be >.
            System.out.println("\nTransfer C failed, not enough balance!");
        }

    }
}
