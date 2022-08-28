package XHS.TWO;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        long n = cin.nextLong();
        long k = cin.nextLong();//方案vv
        long[][] dp = new long[(int) n][(int) k];
        //从0~i种法术种选出两个法术，他们的最大乘积是多少
        long[] magics = new long[(int) n];
        for(int i = 0; i < n; i++) {
            magics[i] = cin.nextLong();
        }
        if(n == 1) {
            System.out.println(0);
            return;
        }
        long count = 0;
        int left = 0;
        int right = magics.length;
        Arrays.sort(magics);
        for(left = 0, right = magics.length; left < right; left++) {
            while(right > 0 && magics[right-1] * magics[left] >= k) right--;
            if(left <= right) {
                count = count + n - right - 1;
            } else {
                count = count + n - right;
            }
        }
        System.out.println(count);


    }


    public static int solutionOne(long n, long k, long[] magics) {
        int count = 0;
        long nums;
        for(int i = 0; i < n; i++) {
            nums = 1;
            for(int j = i+1; j < n; j++) {
                nums = magics[i] * magics[j];
                if(nums >= k) {
                    count++;
                }
            }
        }
        return count*2;
    }
}
