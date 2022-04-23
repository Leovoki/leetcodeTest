package ThreadTest;

public class ThreadTest06 {
    public static void main(String[] args) {
        //让当前线程进休眠
        //当前线程是主线程
        try {
            Thread.sleep(1000 * 5);//五秒
            System.out.println("我执行了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
