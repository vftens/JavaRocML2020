import java.util.Calendar;
import java.util.Date;

class DepositaryAccount extends BankAccount {
    // с которого нельзя снимать деньги в течение месяца после последнего внесения
    public DepositaryAccount() {
        super();
    }

    private Date dateOp;
    public boolean result;

    public DepositaryAccount(double i) {
        super(i);
    }

    public boolean getresult(){
        return result;
    }

    public Date getDateOp() {
        return dateOp;
    }

    public void deposit(double amount){
        super.deposit(amount);
        setDateOp();
    }

    public void setDateOp() {
        //Date dateOp
        //current(Date);
        Date today = new Date();
        this.dateOp = today; //dateOp;
    }

    public void withdraw(double amount) {
        Date today = new Date();
        if (getDateSub(today)) {//today - getDateOp()
            super.withdraw(amount);
            result = true;
        } else {
            result = false;
        }
    }

    public boolean getDateSub(Date today){ // прошел месяц
        //Calendar calendar = new GregorianCalendar();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, -1);
        
        if (calendar.before(getDateOp())){ // больше месяца
            return true;
        }
        return false;
    }
}
