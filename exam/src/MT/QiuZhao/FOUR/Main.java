package MT.QiuZhao.FOUR;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
        }
        int ans = 0;
        //a[i]+a[k] = 3a[j]
        //i<j<k
        int target = 0;
        Map<Integer,Integer> map = new HashMap<>();//专门用来记录a[i]的个数
        for(int j = 1; j < n-1; j++) {
            map.put(a[j-1],map.getOrDefault(a[j-1],0)+1);
            for(int k = j+1; k < n; k++) {
                target = 3 * a[j] - a[k];//这是a[i]
                ans = ans + map.getOrDefault(target,0);

            }
        }
        System.out.println(ans);
    }
}
