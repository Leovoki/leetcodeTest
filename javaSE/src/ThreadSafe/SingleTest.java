package ThreadSafe;

public class SingleTest {
    public static void main(String[] args) {
        SingleInstance.YUYIMING.setAge("24");
        System.out.println(SingleInstance.YUYIMING.toString());
        //System.out.println(SingleInstance.YUYIMING.getId());
    }
}
