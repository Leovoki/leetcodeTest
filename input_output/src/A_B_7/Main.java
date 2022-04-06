package A_B_7;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int sum = 0;
        while(cin.hasNextLine()) {
            String[] a = cin.nextLine().split(" ");
            sum = 0;
            for(int i = 0; i < a.length; i++) {
                sum+=Integer.parseInt(a[i]);
            }
            System.out.println(sum);
        }
    }
}