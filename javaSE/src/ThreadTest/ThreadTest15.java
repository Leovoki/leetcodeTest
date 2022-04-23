package ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;//并发包，jdk8新特性

public class ThreadTest15 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //第一步创建一个未来任务类对象
        //参数非常重要，需要一个callable接口的实现类对象
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("call method begin");
                Thread.sleep(1000);
                System.out.println("call method end");
                int a = 100;
                int b = 200;
                return a + b;
            }
        });

        Thread t = new Thread(task);
        t.start();
        Thread.sleep(1000*5);

        //在这里是Main方法，怎么获取t线程的返回结果呢？
        //能，但是可能导致当前线程阻塞，毕竟需要等待另一个线程处理完后返回结果
        Object obj = task.get();
        System.out.println(obj);
    }
}
