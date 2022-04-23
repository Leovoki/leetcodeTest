package ThreadTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 消费生产
 */
public class ThreadTest16 {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        Thread consumer = new Thread(new Consumer(list));

        Thread producer = new Thread(new Producer(list));

        producer.start();
        consumer.start();

    }
}

class Producer implements Runnable {
    private List list;

    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.size() > 0) {
                    try {
                        list.wait();//走到这一步就是线程进行等待，并且释放现在的锁。因为释放了锁，所以消费者就有锁可以去消费了
                        //当消费者消费后notify(),notify()并不释放锁哦，只是说明卡在wait部分的函数可以继续执行下去了，毕竟现在
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    Object obj = new Object();
                    list.add(obj);
                    System.out.println(Thread.currentThread().getName() + "---->生产" + obj);
                    //此时需要唤醒消费者去消费
                    list.notify();
                }

            }
        }
    }
}


class Consumer implements Runnable {
    private List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.size() == 0) {
                    try {
                        list.wait();//没有东西了，不消费了，释放锁。消费者本线程去等待。此时其它线程有机会抢锁，比如生产者线程
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    Object obj = list.remove(list.size() - 1);
                    System.out.println(Thread.currentThread().getName() + "---->消费" + obj);

                    //前面生产者一直卡在wait处，此时需要唤醒。注意唤醒不会释放占用锁，只有等到此函数执行完，才真的释放锁！
                    list.notify();
                }


            }
        }

    }
}
