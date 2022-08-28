package ByteDance.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int  t= cin.nextInt();
        while(t-- > 0) {
            int n = cin.nextInt();//数组长度
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = cin.nextInt();//记录数组
            }
            //
            Long max = 1L;int start = 0;int end = -1;//说明并不是一个答案
            Map<Long, Integer[]> result = new HashMap<>();
            result.put(0L,new Integer[]{0,0});//初始化
            for(int i = 0; i < n; i++) {
                //如果一直都是非0，则一直乘下去
                if(nums[i] != 0) {
                    max = max*nums[i];
                    end = i;
                    //每次有一个结果后，都先试着放进去
                    putMax(result, max, start, end);
                } else {
                   //0出现
                    max = 1L;
                    start = i+1;
                }
            }
            max = 0L;
            for(Map.Entry<Long, Integer[]> entry : result.entrySet()) {
                max = Math.max(entry.getKey(), max);
            }
            System.out.println(++result.get(max)[0] + " " + ++result.get(max)[1]);
        }
    }


    public static void putMax(Map<Long, Integer[]> result, Long max, int start, int end) {
        if(result.containsKey(max)) {
            int x = result.get(max)[0];
            int y = result.get(max)[1];
            if(x == start) {
                //x一样，则放y小的
                if(end < y) {
                    result.put(max, new Integer[]{start, end});
                }
            } else if(x > start) {
                //放x小的
                result.put(max, new Integer[]{start, end});
            }
        } else {
            //没有这个解，当前就是最优解
            result.put(max, new Integer[]{start, end});
        }
    }
}
