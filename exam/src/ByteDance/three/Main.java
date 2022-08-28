package ByteDance.three;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int a[] = new int[n+5];
        long pre[] = new long[n+5];
        long post[] = new long[n+5];
        a[0] = 0;
        for(int i = 1; i <= n; i++) {
            a[i] = cin.nextInt();
        }
        pre[0] = 0;
        long tmp = 0;
        for(int i = 1; i <=n; i++) {
            if(tmp > 0) tmp = tmp + a[i];
            else tmp = a[i];
            if (pre[i-1] < tmp) pre[i] = tmp;
            else pre[i] = pre[i-1];
        }
        post[n+1] = 0;
        tmp = 0;
        for(int i = n; i >= 1; i--) {
            if(tmp > 0) tmp = tmp + a[i];
            else tmp = a[i];
            if(post[i+1] < tmp) post[i] = tmp;
            else post[i] = post[i+1];
        }
        long ans = 0;
        for(int i = 1; i < n; i++) {
            long tmp2 = pre[i] + post[i+1];
            if(ans < tmp2) ans = tmp2;
        }
        System.out.println(ans);
    }
}
