package XIECHENG.FOUR;

import java.util.Scanner;

public class Main {
    static long mod = 1000000007;
    static long inv2 = 500000004;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        long n = cin.nextLong();
        if(n == 2) {
            System.out.println(20);
        } else {
            long ans = sum(1,4) * 2 % mod
            + sum(5, (4*n-4)%mod) * 3 % mod
                    +sum((4*n-3)%mod, n * n% mod)* 4 % mod;
            System.out.println(ans);
        }
    }

    private static long sum(long x) {
        return x * (x+1) % mod * inv2 % mod;
    }

    private static long sum(long begin, long end) {
        return ((sum(end) - sum(begin-1)) % mod + mod) % mod;
    }
}
