package ThreadTest;

public class ThreadTest02 {
    public static void main(String[] args) {
        System.out.println("开始时间：" + System.currentTimeMillis());
        //这里是main方法，主线程
        MyThread1 myThread = new MyThread1();
        myThread.start();//作用是在jvm中，开辟一个新的栈空间，启动一个分支线程后，代码任务就瞬间结束了。
        for(int i = 0; i < 100; i++) {
            System.out.println("主线程-->" + i);
        }
        System.out.println(System.currentTimeMillis());
    }
}

class MyThread1 extends Thread {

    @Override
    public void run() {
        for(int i = 0; i < 100;i++) {
            System.out.println("我的线程--> 9999");
        }
        System.out.println(System.currentTimeMillis());
    }
}

