public class BankAccount {
    private double balance = 0; //

    public BankAccount() {

    }

    public BankAccount(double amount) {
        deposit(amount);
    }

    public BankAccount(BankAccount bank, double amount) {
        //super(bank);
        deposit(amount);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // который будет переводить деньги с счета на счет.
    public boolean transferTo(BankAccount bank, double amount) {
        if(this.withdraw(amount)){
            bank.deposit(amount);
            System.out.println("\nTransfer C successful. Transfered: $" + amount);
            return true;
        }
        else {
            //does not need to be else if, because if not <=, it MUST be >.
            System.out.println("\nTransfer C failed, not enough balance!");
        }
        return false;
    }
}