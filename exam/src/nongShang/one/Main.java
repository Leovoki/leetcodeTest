package nongShang.one;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static Integer result = 0;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        char[] s = cin.nextLine().toCharArray();
        int size = s.length;
        int[][] dp = new int[size+1][2];//0是元音
        //长度为i，结尾是辅音/元音的字符长长度为dp
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("e");
        set.add("i");
        set.add("o");
        set.add("u");
        int total = 0;
        for(int i = 0; i < size; i++) {
            if(set.contains(s[i])) {
                total++;
            }
        }
        int fu = size - total;//辅音个数
        dp[1][0] = 5;
        dp[1][1] = 21;
        for(int i = 2; i <= size; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]*5);
            dp[i][1] = dp[i-1][0] * 21;
        }
        System.out.println();



    }

    public static void find(int pre, int fu, int yuan, int path) {
        if(fu == 0) {
            path = path + yuan;
            result = Math.max(result, path);
            return;
        } else if(yuan == 0 && fu > 0) {
            path++;
            result = Math.max(result, path);
            return;
        }

        while(fu != 0 && yuan != 0) {
            for(int i = 0; i < 2; i++) {
                if(i == 0) {
                    if(pre != -1) {
                        fu--;
                        pre = -1;
                        find(pre, fu, yuan, path+1);
                    } else {
                        yuan--;
                        pre = 1;
                        find(pre, fu, yuan, path+1);
                    }
                }
            }
        }
    }
}
