package _60;

import java.util.ArrayList;
import java.util.List;

public class DpSolution {
    public static void main(String[] args) {
        int n = 2;
        double[] res = dicesProbability(n);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }

    public static double[] dicesProbability(int n) {
        int[][] dp = new int[n+1][n*6+1];
        //表示投第i个骰子的时候，总点数是j的次数
        //递推关系，肯定由前一个
        //dp[i][j] = dp[i-1][j-(1~6)]

//初始化
        for(int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; i++) {//表示第几个骰子
            for(int j = i; j <= 6*i; j++) {//表示投第i个骰子时，出现的可能
                for(int val = 1; val <= 6; val++) {//第i个骰子投出的数字
                    if(j-val <= 0) break;
                    dp[i][j] += dp[i-1][j-val];//计算次数
                }
            }
        }
        List<Double> res = new ArrayList<>();
        double all = Math.pow(6,n);
        for(int i = n; i <= 6*n; i++) {
            res.add(dp[n][i]/all);
        }

        double[] result = new double[res.size()];//最终的答案
        for(int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

}
