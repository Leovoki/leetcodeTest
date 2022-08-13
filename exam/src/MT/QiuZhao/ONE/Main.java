package MT.QiuZhao.ONE;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int t = cin.nextInt();
        int[] times = new int[n];
        for(int i = 0; i < n; i ++) {
            times[i] = cin.nextInt();
        }
        Arrays.sort(times);
        int now = 0;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int time = times[i];
            if(now+t<=time) {
                now += t;
            } else {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
