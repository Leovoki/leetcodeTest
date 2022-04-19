package jd1.Two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int[] hash = new int[1000001];
        int count = 0;
        for (int i = 0; i < 1000001; i++) {
            hash[i] = i / 2;
        }
        List<Integer> res = new ArrayList<>();
        int t = cin.nextInt();
        while (t-- > 0) {
            int n = cin.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = cin.nextInt();
            }
            Arrays.sort(nums);
            int len = nums.length;
            int min = 0;//最小中位数位置
            if (len % 2 == 0) {
                //偶数
                min = len % 2 - 1;
            } else {
                //奇数
                min = len / 2;
            }
            //从后往前数，基本啥为了中位数的中心靠后，后排的数字是不会放弃的
            int end = nums.length - 1;
            for (end = end; end >= min; end--) {
                //后面的数字
                int backNum = len - end - 1;
                //前面有多少数字
                int frontNum = end;

                //从前面要么选出back个数，要么选出back-1个数,导致可以让间隔相邻
                int[] need = new int[2];
                need[0] = backNum;
                need[1] = backNum - 1;
                int real = hash[frontNum];//real表示前面至少需要多少数字
                if(real == need[0] || real == need[1]) {
                    res.add(nums[end]);
                    break;
                } else {
                    continue;
                }
            }
        }
        for(Integer a : res) {
            System.out.println(a);
        }
    }
}
