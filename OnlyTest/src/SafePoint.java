import java.util.HashMap;
import java.util.Map;

public class SafePoint {
    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("大循环还在继续！");
                }
            }
        });
        t0.start();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Map<Object, String> map = new HashMap<>();
                for(int i = Integer.MAX_VALUE; i > 0; i--) {
                        //System.out.println("。");
                    //map.put(new Object(), String.valueOf(i));
                }
                System.out.println(Thread.currentThread().getName() + ":大循环结束");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++) {

                }
                System.out.println("小循环");
            }

        });

        t1.start();
        t2.start();
        Thread.sleep(10);
        System.out.println("主线程结束");
    }
}
