package PreBatch.WeiLai.THREE;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin  = new Scanner(System.in);
        long n = cin.nextLong();
        long k = cin.nextLong();
        HashMap<Long, Long> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            long temp = cin.nextLong();
            if(map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1L);
            }
        }
        long ans = 0;
        for(Map.Entry<Long, Long> entry : map.entrySet()) {
            long temp = k - entry.getKey();
            if(map.containsKey(temp)) {
                ans = ans + Math.min(entry.getValue(), map.get(temp));
            }
        }
        System.out.println(ans/2);
    }
}
