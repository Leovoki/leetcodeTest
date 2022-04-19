package XC.THREE;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //long mod = 1000000007;
        long mod = (long) (1e9 + 7);
        Scanner cin = new Scanner(System.in);
        char[] str = cin.nextLine().toCharArray();
        int n = str.length;
        long[][] dp = new long[200005][10];

        dp[0][0] = 1;
        for(int i = 1; i <=n; i++) {
            for(int j = 0; j <10; j++) {
                dp[i][j] = dp[i-1][j];
            }
            for(int j = 0; j < 7; j++) {
                int v = (str[i-1] -'0');
                int k = ((j+v) % 9 + 9) % 9;
                dp[i][k] = (dp[i][k] + dp[i-1][j]) % mod;
            }
        }
        long ans = dp[n][0]-1;
        System.out.println(ans);
    }
}
