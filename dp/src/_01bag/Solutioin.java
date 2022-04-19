package _01bag;

public class Solutioin {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;
        testweightbagproblem(weight, value, bagsize);
    }

    public static void testweightbagproblem(int[] weight, int[] value, int bagsize) {
        //从0~i个物品中选择，背包容量为j时，的背包最大价值时多少
        int[][] dp = new int[weight.length+1][bagsize+1];
        //确定递推公式
        /**
         * dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i])
         */

        //初始化，当背包容量是0的时候，永远值为0
        for(int i = 0; i < weight.length; i++) {
            dp[i][0] = 0;
        }
        //当只能选i=0这个物品的时候
        for(int i = 0; i < weight[0]; i++) {
            dp[0][i] = 0;//空间不够为0
        }
        for(int i = weight[0]; i <= bagsize; i++) {
            dp[0][i] = value[0];
        }
        //之所以这么初始化，是因为所有的递推值都是从左上方包括正上方来的，因此必须把第一列第一排的值先计算好。
        for(int item = 1; item < weight.length; item++) {
            for(int space = 0; space <= bagsize; space++) {
                if(space>=weight[item]) {
                    dp[item][space] = Math.max(dp[item-1][space], dp[item-1][space-weight[item]] + value[item]);
                } else {
                    //说明空间根本不够放下
                    dp[item][space] = dp[item-1][space];
                }
            }
        }

        //打印dp数组
        for (int i = 0; i <= weight.length; i++){
            for (int j = 0; j <= bagsize; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }


    }
}
