class BankAccount  {
    private volatile double balance = 0; // volatile is neccesary

    public BankAccount() {

    }

    public BankAccount(double i) {
        new BankAccount();
        deposit(i);
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    private void withdraw() {
        withdraw();
    }

    public boolean withdraw(double amount) {
        if (balance - amount > 0) {
            balance = balance - amount;
            return true;
        }
        return false;
    }
}