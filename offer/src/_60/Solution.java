package _60;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

//该方法超时了
public class Solution {
    private static TreeMap<Integer, Integer> map = new TreeMap<>();
    public static void main(String[] args) {
        int n = 2;
        double[] res = dicesProbability(n);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }


    }

    public static double[] dicesProbability(int n) {
        backTracking(n,0);
        Double totalTime = 0.0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            totalTime+=entry.getValue();
        }
        double[] result = new double[map.size()];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[i++] = entry.getValue()/totalTime;
        }
        return result;
    }

    public static void backTracking(int n, int sum) {
        if(n == 0) {
            //说明已经到低了
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return;
        }
        for(int i = 1; i <= 6; i++) {
            backTracking(n-1, sum + i);
        }
    }
}
