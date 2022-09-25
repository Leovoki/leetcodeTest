package pdd.two;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();//山数量
        int p = cin.nextInt();//一次最高能爬的高度
        int k = cin.nextInt();//一次最多跨越台阶数
        int maxDis = p * k;
        while(n-- > 0) {
            int num = cin.nextInt();//台阶总数
            int[] dp = new int[num+1];//爬到第i层又dp【i]方法
            int[] height = new int[num+1];
            for(int i = 1; i <= num; i++) {
                height[i] = cin.nextInt();
            }
            dp[0] = 1;
            if(height[0] > p) {
                System.out.println(0);
                continue;
            }
            dp[1] = 1;
            if(height[1] > p) {
                System.out.println(0);
                continue;
            } else if (k >= 2 && height[0] + height[1] <= p) {
                dp[2] = 1;
            } else {
                dp[2] = 2;
            }
            for(int i = 3; i <= num; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            System.out.println(dp[num]);

        }

    }
}
