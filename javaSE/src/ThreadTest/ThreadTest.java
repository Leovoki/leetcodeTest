package ThreadTest;

public class ThreadTest {
    public static void main(String[] args) {
        Ticket myTicket = new Ticket();
        MyThread myThread = new MyThread(myTicket);
        //myThread.start();

        OtherThread otherThread = new OtherThread();
        new Thread(otherThread,"牛逼黄牛").start();
        new Thread(otherThread,"张三").start();
        new Thread(otherThread,"超级黄牛").start();
        new Thread(otherThread,"吕扬丞").start();


    }
}
class OtherThread implements Runnable {
    private Integer num = 10;
    @Override
    public void run() {
        while(true) {
            synchronized (num) {
                if(num > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "抢到第" + num-- + "张票");
                }
            }
        }

    }
}

class MyThread extends Thread{
    private Ticket ticket;

    public MyThread (Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while(ticket.getNum()>0) {
            System.out.println("分支线程：" + ticket.getNum());
        }
    }
}

class Ticket {
    private Integer num;

    public Ticket() {
        this.num = 10;
    }

    public int sell() {
        this.num--;
        return this.num;
    }

    public Integer getNum() {
        return num;
    }
}
