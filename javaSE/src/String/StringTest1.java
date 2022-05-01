package String;

public abstract class StringTest1 {

    public StringTest1() {
        int a = new Integer(2);
    }

    public static void main(String[] args) {
        Integer a = new Integer(100);
        Integer b = new Integer(100);
        while(true) {
            System.out.println(a == b);
        }

    }
}
