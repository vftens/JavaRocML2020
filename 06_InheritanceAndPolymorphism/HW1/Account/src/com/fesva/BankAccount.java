public abstract class BankAccount {
    private double balance = 0; //

    public BankAccount() {

    }

    public BankAccount(double amount) {
        /*
        new BankAccount() {
            @Override
            public void transferTo(DepositaryAccount bank, double amount) {

            }
        };

         */
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
    public void transferTo(double amount){
        //
        if(withdraw(amount)){
            this.deposit(amount);
            System.out.println("\nTransfer B successful. Transfered: $" + amount);
        }
        else {
            //does not need to be else if, because if not <=, it MUST be >.
            System.out.println("\nTransfer B failed, not enough balance!");
        }
    };

     // который будет переводить деньги с счета на счет.
     public abstract void transferTo(DepositaryAccount bank, double amount);
 }