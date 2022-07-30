package PreBatch.XingHuan.TWO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int num = cin.nextInt();
        Integer[] pos = new Integer[n+1];
        for(int i = 1; i <= n; i++) {
            pos[i] = cin.nextInt();
        }
        int[][] dp = new int[302][302];
        int[][] w = new int[302][302];
        for(int i = 1; i <= n; i++) {
            for(int j = i+1; j <=n; j++) {
                w[i][j] = w[i][j-1] + pos[j] - pos[(i+j)/2];
            }
        }
        //初始化
        for(int i = 1; i <= n; i++) {
            dp[i][1] = w[1][i];
            dp[i][i] = 0;
        }
        for(int i = 1; i <=n ; i++) {
            for(int j=2; j<=Math.min(num,i);j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = j; k <= i-1;k++) {
                    dp[i][j] = Math.min(dp[i][j],dp[k][j-1]+w[k+1][i]);
                }
            }
        }
        System.out.println(dp[n][num]);
    }
}
