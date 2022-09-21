package xiaomi.two;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String word1 = cin.nextLine();
        String word2 = cin.nextLine();

        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for(int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= word1.length(); i++) {
            for(int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int a = dp[i-1][j] + 1;
                    int b = dp[i][j-1] + 1;
                    int c = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(a, Math.min(b,c));
                }
            }
        }
        System.out.println(dp[word1.length()][word2.length()]);

    }
}
