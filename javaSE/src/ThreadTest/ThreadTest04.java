package ThreadTest;

public class ThreadTest04 {
    public static void main(String[] args) {
        //采用匿名内部类的方式
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++) {
                    System.out.println("t线程" + i);
                }
            }
        });

        t.start();
        for(int i = 0; i < 100; i++) {
            System.out.println("main线程" + i);
        }
    }
}
