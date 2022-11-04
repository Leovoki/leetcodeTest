package citi.one;

public class Main {
    public static void main(String[] args) {
        Object a = getData((byte) 001, 1.1f);
        System.out.print(a);
    }

    public static Object getData(byte a, double z) {
        return (short)a/z*10;
    }

}

class Test {
    void method() {

    }
}

class Test1 extends Test {

     void method() {

    }
}
