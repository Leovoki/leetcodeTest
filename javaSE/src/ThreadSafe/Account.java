package ThreadSafe;

public class Account {
    private String accountNo;
    private Double balance;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Account() {

    }

    public Account(String accountNo, Double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public void withdraw(double money) {
        //必须让一个线程把这里的代码全部执行完，另一个线程才能进来
        /**
         * 线程同步机制
         *synchronized(){
         *
         * }
         * 括号中的数据必须是多线程共享的数据
         * （）写什么
         * 假如有t1,t2,t3,t4,t5五个线程
         * 如果你只希望1，2，3排队，那你只能写123共享的对象，45不共享的对象
         * 这里的共享对象是账户对象
         * 那么this就是账户对象了
         */
        Object obj1 = new Object();//这个变量却不能作为共享对象，因为这是局部变量
        String sb = "abc";//这个在常量池，所有线程共享
        synchronized (this.balance) {
            double before = this.getBalance();
            double after = before - money;
            if(after < 0) {
                System.out.println("余额不足");
                return;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setBalance(after);
            System.out.println(Thread.currentThread().getName() + "成功取款 " + money + " 成功，" + "余额为：" + this.getBalance());
        }


        try {
            Thread.sleep(1000*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
