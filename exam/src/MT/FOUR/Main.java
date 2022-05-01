package MT.FOUR;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t-- > 0) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            if(n<2 || m < 2) {
                System.out.println("No");
            }
        }

    }
}
