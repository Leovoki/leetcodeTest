package ThreadTest;


public class ThreadTest08 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyRunnable2 r = new MyRunnable2();
        Thread t = new Thread(r);
        t.start();

        //希望主线程干完，子线程再干活
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.run = false;
        //t.interrupt();//干扰一碰冷水过去，方法是靠 让该线程的sleep方法抛出异常，走catch，然后结束睡眠，继续运行
    }
}


class MyRunnable2 implements Runnable {
    boolean run = true;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--> begin");


        try {
            for(int i = 0; i < 10; i++) {
                if(run) {
                    System.out.println(Thread.currentThread().getName() + "-->" + i);
                    Thread.sleep(1000);//一秒
                } else {
                    System.out.println(Thread.currentThread().getName() + " 终止");
                    return;
                }
            }
        } catch (InterruptedException e) {
            //看看会不会打
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--> end");
    }
}
