package ThreadTest;

/**
 * 获取当前线程对象
 * 获取当前线程对象的名字
 * 修改线程对象的名字
 */
public class ThreadTest05 {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());


        MyThread2 t = new MyThread2();
        System.out.println(t.getName());
        //设置线程名字
        t.setName("ttt");
        t.start();
        System.out.println(t.getName());


    }
}

class MyThread2 extends Thread {

    public void run() {
        Thread currentThread = Thread.currentThread();
        for(int i = 0; i < 100;i++) {
            System.out.println(currentThread.getName() + i);
        }
        System.out.println(System.currentTimeMillis());
    }
}


