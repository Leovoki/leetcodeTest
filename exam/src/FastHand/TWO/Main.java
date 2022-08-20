package FastHand.TWO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] mountain = new int[n+1][n+1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <=n; j++) {
                mountain[i][j] = -1;
            }
        }
        int level = 1;
        while(level <= n) {
            for(int i = 1; i < n; i++) {
                if(i > level) {
                   continue;
                } else {
                    mountain[level][i] = cin.nextInt();
                }

            }
            level++;
        }
        level = 2;
        int[][] dp = new int[n+1][n+1];
        //到达表示第i层，第j列能够获得的最大值是多少
        dp[1][1] = mountain[1][1];
        for(int i = 2; i <= n && level <= n; i++) {
            for(int j = 1; j <= level; j++) {
                if(mountain[i-1][j-1] == -1) {
                    //如果没有左上方的节点
                    dp[i][j] = mountain[i][j] + dp[i-1][j];
                } else if(mountain[i-1][j] == -1){
                    //没有正方法的
                    dp[i][j] = mountain[i][j] + dp[i-1][j-1];
                } else {
                    dp[i][j] = mountain[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
            level++;
        }
        int result = 0;
        for(int i = 1; i <=n; i++) {
            result = Math.max(result, dp[n][i]);
        }
        System.out.println(result);
    }
}
