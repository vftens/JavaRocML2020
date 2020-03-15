import java.time.LocalDate;
import java.util.Date;

class DepositaryAccount extends BankAccount {
    // с которого нельзя снимать деньги в течение месяца после последнего внесения
    public DepositaryAccount() {
        super();
    }

    private Date dateOp;

    public DepositaryAccount(double i) {
        super(i);
    }

    public Date getDateOp() {
        return dateOp;
    }

    public void deposit(double amount) {
        super.deposit(amount);
        setDateOp();
    }

    public void setDateOp() {

        Date today = new Date();
        this.dateOp = today; //dateOp;
    }

    public boolean withdraw(double amount) {
        if (getDateSub()) {//today - getDateOp()
            super.withdraw(amount);
            return true;
        }
        return false;
    }

    public boolean getDateSub() {
        // прошел месяц ?

        LocalDate today1 = LocalDate.now();
        LocalDate localDate = today1.minusMonths(1);
        LocalDate localDateOp = DateUtils.asLocalDate(getDateOp());

        if(localDateOp.isBefore(localDate)) {
            return true;
        }
        return false;
    }
}
