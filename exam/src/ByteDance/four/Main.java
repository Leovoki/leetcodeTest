package ByteDance.four;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        List<Integer> a = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            a.add(cin.nextInt());
        }
        long ans = 0;
        long sum = 0;
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            tree.put(a.get(i), tree.getOrDefault(a.get(i),0)+1);
            sum += a.get(i);
            if(i >= k) {
                int min = tree.firstEntry().getKey();
                if(ans < sum - min) ans = sum - min;
                sum -= a.get(i-k);//减去范围外的数字
                int cnt = tree.get(a.get(i-k));
                if(cnt > 1) {
                    tree.put(a.get(i-k), cnt -1);
                } else {
                    tree.remove(a.get(i-k));
                }
            }
        }
        System.out.println(ans);
    }
}
