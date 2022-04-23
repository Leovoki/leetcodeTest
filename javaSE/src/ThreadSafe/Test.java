package ThreadSafe;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //创建一账户
        Account account = new Account("1", 10000.0);

        Thread t1 = new AccountThread(account);
        Thread t2 = new AccountThread(account);
        Thread t3 = new AccountThread(account);
        Thread t4 = new AccountThread(account);
        Thread t5 = new AccountThread(account);
        Thread t6 = new AccountThread(account);
        Thread t7 = new AccountThread(account);
        Thread t8 = new AccountThread(account);

        //启动取款
        t1.start();;
        //Thread.sleep(1000*5);
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();


    }
}
