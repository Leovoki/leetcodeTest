package A_B_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(!cin.hasNext("0")) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            System.out.println(a+b);
        }
    }
}
