import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, -2);

        DepositaryAccount depAcc;
        depAcc = new DepositaryAccount(120);
        depAcc.deposit(180);

        if (depAcc.withdraw(110)){
            //depAcc.getresult())
            System.out.println("Withdraw sucessful ");
        } else {
            System.out.println("Withdraw denied ");
        }

        System.out.println("Баланс Депозитарный: " + depAcc.getBalance());

        CardAccount acc;
        acc = new CardAccount(100);
        acc.deposit(200);
        if (acc.withdraw(50)){
            System.out.println("Withdraw allowed.");
        }
        else {
            System.out.println("Withdraw denied.");
        }
        System.out.println("Итоговый баланс: " + acc.getBalance());
    }
}
