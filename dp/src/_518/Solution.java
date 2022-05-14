package _518;

class Solution {
    public static void main(String[] args) {
        int amount = 6;
        int[] coins = {1,5};
        System.out.println(change(amount,coins));

    }
    public static int change(int amount, int[] coins) {
        //这种写法是完全背包求组合数
        int[] dp = new int[amount+1];
        //凑成j元的种类
        dp[0] = 1;

        for(int i = 0; i < coins.length;i++) {
            for(int j = coins[i]; j <= amount; j++) {

                dp[j] = dp[j] + dp[j-coins[i]];
                //System.out.printf("coins = %d, dp[%d] = %d\n",coins[i],j,dp[j]);

            }
        }
        //这种写法是完全背包求排列数
        int[] pai = new int[amount+1];
        pai[0] = 1;
        for (int j = 0; j <= amount; j++) { // 遍历背包容量
            for (int i = 0; i < coins.length; i++) { // 遍历物品
                if (j - coins[i] >= 0) {
                    System.out.printf("pai[%d] = %d\n",j,pai[j]);
                    pai[j] += pai[j - coins[i]];
                    System.out.printf("coins = %d, pai[%d] = %d\n",coins[i],j,pai[j]);
                    System.out.println("--------------------------");
                }

            }
        }
        return dp[amount];

    }
}