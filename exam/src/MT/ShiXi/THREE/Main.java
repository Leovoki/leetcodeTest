package MT.ShiXi.THREE;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t-- > 0) {
            int n = cin.nextInt();
            int[] nums = new int[n];
            int[] colors = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = cin.nextInt();
            }
            for(int i = 0; i < n; i++) {
                colors[i] = cin.nextInt();
            }
            Map<Integer, List<Integer>> pair = new HashMap<>();
            //key是颜色，list按照顺序放数字
            for(int i = 0; i < n; i++) {
                int color = colors[i];
                int number = nums[i];
                List<Integer> list = pair.getOrDefault(color,new ArrayList<>());
                list.add(number);
                pair.put(color,list);
            }
            //装箱完毕
            Set<Map.Entry<Integer, List<Integer>>> entrySet = pair.entrySet();
            boolean ans = true;
            for (Map.Entry s : entrySet) {
                List<Integer> list = (List<Integer>) s.getValue();
                if(checkSort(list)) {
                    continue;
                } else {
                    ans = false;
                    break;
                }

            }
            if(ans) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean checkSort(List<Integer> list) {
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) < list.get(i-1)) {
                return false;
            }
        }
        return true;
    }
}
