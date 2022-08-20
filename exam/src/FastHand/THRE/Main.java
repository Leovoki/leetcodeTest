package FastHand.THRE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        List<List<Integer>> a = new ArrayList<>();
        List<Integer> cnt = new ArrayList<>();
        List<Long> value = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            a.add(new ArrayList<>());
            cnt.add(0);
            value.add(0L);
        }
        for(int i = 1; i < n; i++) {
            int x = cin.nextInt();
            int y = cin.nextInt();
            a.get(x).add(y);
            a.get(y).add(x);
        }
        dfsCount(0, -1, a, cnt);
        dfsValue(0, -1, n, a, cnt, value);
        long maxValue = 0;
        for(int i = 0; i < n; i++) {
            if(value.get(i) > maxValue) maxValue = value.get(i);
        }
        int maxCnt = 0;
        for(int i = 0; i < n; i++) {
            if(value.get(i) == maxValue) maxCnt++;
        }
        System.out.println(maxCnt + " " + maxValue % 1000000007);
    }

    public static int dfsCount(int cur, int fa, List<List<Integer>> a, List<Integer> cunt) {
        int sum = 1;
        for(int child : a.get(cur)) {
            if(child != fa) {
                sum+=dfsCount(child, cur, a, cunt);
            }
        }
        cunt.set(cur, sum);
        return sum;
    }

    public static void dfsValue(int cur, int fa, int n, List<List<Integer>> a, List<Integer> cnt, List<Long> value) {
        long mul = 1;
        if(fa != -1) {
            mul *= n - cnt.get(cur);
        }
        for(int child : a.get(cur)) {
            if(child != fa) {
                mul *= cnt.get(child);
                dfsValue(child, cur, n, a , cnt, value);
            }
        }
        value.set(cur, mul);
    }

}



