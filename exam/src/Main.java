public class Main {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(numsOfStrings(n,k));
    }
    public static int numsOfStrings (int n, int k) {
        long key = 1000000;
        Long[][] dp = new Long[n+1][k+1];
        Long[][] sum = new Long[n+1][k+1];
        //表示长度为n的字符串，连续长度为k的个数是dp个
        for(int i = 0; i <= n;i++) {
            dp[i][0] = 1L;
            sum[i][0] = 1L;
            for(int j = 1; j <= k; j++) {
                dp[i][j] = 0L;
                sum[i][j] = 0L;
            }
        }

        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <=k; j++) {
                int bei = 26;
                if(j > 1) bei = 25;
                if(i >= 2) {
                    dp[i][j] = sum[i-2][j-1] * bei % key;
                    System.out.printf("dp[%d][%d] = sum[%d][%d] * %d\n",i,j,i-2,j-1,bei);
                    System.out.printf("dp[%d][%d] = %d\n",i,j,dp[i][j]);
                }
                sum[i][j] = (sum[i-1][j] + dp[i][j]) % key;
                System.out.printf("sum[%d][%d] = (sum[%d][%d] + dp[%d][%d])\n",i,j,i-1,j,i,j);
                System.out.printf("sum[%d][%d] = %d\n",i,j,sum[i][j]);
            }
        }
        //String res = dp[n][k].toString();
        return dp[n][k].intValue();

    }
}
