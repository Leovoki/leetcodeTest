package A_B_5;

import java.util.*;

public class Main {
    public static void main(String[] ags) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t-- > 0) {
            int n = cin.nextInt();
            int sum = 0;
            while(n-- > 0) {
                sum = sum + cin.nextInt();
            }
            System.out.println(sum);
        }
    }
}