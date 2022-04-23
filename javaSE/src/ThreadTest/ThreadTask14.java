package ThreadTest;

/**
 * 守护线程
 * 现在希望main方法一结束，守护线程也结束
 */
public class ThreadTask14 {
    public static void main(String[] args) {
        Thread t = new BakDataThread();
        t.setName("备份数据的线程");
        t.setDaemon(true);
        t.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " BEGIN");
                try {
                    Thread.sleep(1000*10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " END");

            }
        }).start();

        //主线程
        for(int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class BakDataThread extends Thread {
    public void run() {
        int i = 0;
        //即使是死循环，当所有用户结束的时候，自动结束
        while(true) {
            System.out.println(Thread.currentThread().getName() + "--->" + (++i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
