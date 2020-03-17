public abstract class BankAccount {
    private double balance = 0; //

    public BankAccount() {

    }

    public BankAccount(double amount) {
        new BankAccount() {
            @Override
            public void transferTo(DepositaryAccount bank, double amount) {

            }
        };
        deposit(amount);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    private void withdraw() {
        withdraw();
    }

    public boolean withdraw(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // который будет переводить деньги с счета на счет.
    public void transferTo(double amount){
        transferTo(amount);
    };

     // который будет переводить деньги с счета на счет.
     public abstract void transferTo(DepositaryAccount bank, double amount);
 }