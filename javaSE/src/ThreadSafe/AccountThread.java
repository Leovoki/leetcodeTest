package ThreadSafe;

public class AccountThread extends Thread{
    private Account account;
    public AccountThread(Account account) {
        this.account = account;
    }
    public void run() {
        //取款
        double money = 1000;
        account.withdraw(money);

    }
}
