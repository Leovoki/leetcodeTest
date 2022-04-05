public class ThreadTest {
    public static void main(String[] args) {
        Ticket myTicket = new Ticket();
        MyThread myThread = new MyThread(myTicket);
        myThread.start();
        while(myTicket.getNum()>0) {
            System.out.println("主线程：" + myTicket.sell());
        }
//没有锁

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
        this.num = 100;
    }

    public int sell() {
        this.num--;
        return this.num;
    }

    public Integer getNum() {
        return num;
    }
}
