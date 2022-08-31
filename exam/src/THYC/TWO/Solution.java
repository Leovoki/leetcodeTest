package THYC.TWO;

public class Solution {
    public static void main(String[] args) {
        int[] oils = {1,2,5};
        int box = 11;
        System.out.println(change(oils, box));
    }

    public static int change (int[] oils, int box) {
        int[] dp = new int[box+1];
        //能加满大小为j邮箱的组合 最少 个数
        for(int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        //因为是组合个数，因此油桶在外
        for(int i = 0; i < oils.length; i++) {
            for(int j = oils[i]; j <= box; j++) {
                if(dp[j-oils[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-oils[i]]+1);
                }
            }
        }
        return dp[box] == Integer.MAX_VALUE ? -1 : dp[box];
    }
}
