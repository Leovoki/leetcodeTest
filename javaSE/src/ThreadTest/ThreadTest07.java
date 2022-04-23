package ThreadTest;

public class ThreadTest07 {
    public static void main(String[] args) {
        Thread t = new MyThread03();
        t.setName("t");
        t.start();
        try {
            //这行代码会让t线程进入休眠吗？
            t.sleep(1000*5);
            //不会，因为这是个静态方法，反而只会让当前线程进入休眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello world");

    }
}

class MyThread03 extends Thread {
    public void run() {
        for(int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}
