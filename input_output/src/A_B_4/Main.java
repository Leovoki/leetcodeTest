package A_B_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] a) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()) {
            int n = cin.nextInt();
            if(n == 0) {
                break;
            }
            int sum = 0;
            while(n-- > 0) {
                sum = sum + cin.nextInt();
            }
            System.out.println(sum);
        }
    }
}
