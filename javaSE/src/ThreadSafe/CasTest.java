package ThreadSafe;

import java.awt.image.renderable.RenderableImageProducer;
import java.util.concurrent.atomic.AtomicInteger;

public class CasTest {
    static AtomicInteger num = new AtomicInteger(0);//新建原子变量
    public static void main(String[] args) {
        for(int i = 0; i < 3; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(num.get() < 1000) {
                        System.out.println(Thread.currentThread().getName() + ":" + num.incrementAndGet());
                    }
                }
            });
            t.start();
        }

    }
}
