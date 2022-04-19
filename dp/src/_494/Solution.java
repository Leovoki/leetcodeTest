package _494;

class Solution {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0,0,1};
        int target = 1;
        findTargetSumWays(nums, target);
        String a = new String();
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if( (sum - target) % 2 != 0) {
            return 0;
        }
        if( sum - target < 0) {
            //默认nums里的都是非负整数
            return 0;
        }
        int x = (sum - target) / 2;//这是要求的x值，也就是说要满足数字正的数字加起来为x，那看看有多少种符合条件的x



        int[][] dp = new int[nums.length+1][x+1];//装满重量为j的背包有几种方式
        //初始化呢？
        //按行来说，每次只选一个i出来的适合，那么装的内容
        for(int j = 1; j <= x; j++) {
            if(j == nums[j]) {
                dp[0][j] = 1;
                // System.out.println(dp[0][j]);
            }
        }
        if(nums[0] == 0) {
            dp[0][0] = 2;//什么都不装或者装一个0
        } else {
            dp[0][0] = 1;//什么都不装也是一种方案
        }


        //实际上应该是个二维数组，也就是说从0~i个数字中挑选，看能装满书包的方式有多少
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j <= x; j++) {
                if(j>= nums[i]) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]];//不选i的个数和选i的个数
                } else {
                    dp[i][j] = dp[i-1][j];//没法选i,那就不选i的个数
                }

            }
        }

        return dp[nums.length-1][x];

    }
}