import org.jetbrains.annotations.Contract;

class BankAccount implements Account {
    private volatile double balance; // volatile is neccesary

    @Contract(pure = true)
    public BankAccount() {

        balance = 0;
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

    public void insert(int amount) {
        balance = balance + amount;
    }

    private void withdraw() {
        withdraw();
    }

    public void withdraw(double amount) {

        balance = balance - amount;
    }


}