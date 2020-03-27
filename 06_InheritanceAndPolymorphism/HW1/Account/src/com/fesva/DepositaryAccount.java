import java.time.LocalDate;

class DepositaryAccount extends BankAccount {
    // с которого нельзя снимать деньги в течение месяца после последнего внесения
    public DepositaryAccount() {

    }

    LocalDate dateOp;

    public DepositaryAccount(double amount) {
        super(amount);
    }

    public LocalDate getDateOp() {
        return dateOp;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        setDateOp();
    }

    public void setDateOp() {
        LocalDate today =  LocalDate.now();
        this.dateOp = today; //dateOp;
    }

    @Override
    public boolean withdraw(double amount) {
        if (isMonthPassed()) {//today - getDateOp()
            super.withdraw(amount);
            return true;
        }
        return false;
    }

    public boolean isMonthPassed () {
        // прошел месяц ?

        LocalDate today1 = LocalDate.now();
        LocalDate localDate = today1.minusMonths(1);
        LocalDate localDateOp = getDateOp();

        if(localDateOp.isBefore(localDate)) {
            return true;
        }
        return false;
    }

    // который будет переводить деньги с счета на счет.
    @Override
    public boolean transferTo(CardAccount bank, double amount) {
        if (isMonthPassed()) {//today - getDateOp()
            if (withdraw(amount)) {
                bank.deposit(amount);
                System.out.println("\nTransfer D successful. Transfered: $" + amount);
                return true;
            }
        }
        else {
            //does not need to be else if, because if not <=, it MUST be >.
            System.out.println("\nTransfer D failed, not enough balance!");
        }
        return  false;
    }
}
