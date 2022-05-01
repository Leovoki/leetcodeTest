package _1005;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,3,2,6,7,9};
        int k = 3;
        System.out.println(largestSumAfterKNegations(nums,k));
    }



    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        Integer[] a = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
            a[i] = nums[i];
        }
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o2) - Math.abs(o1);
            }
        });
        //如果有负数，全部转正
        int i = 0;
        for(i = 0; i < a.length && k > 0; i++) {
            if(a[i] < 0) {
                a[i] = -a[i];
                k--;
            }
        }
        if(k > 0) {
            Arrays.sort(a);
            if(k%2 == 0) {

            } else {
                a[0] = -a[0];
            }
        }
        return sum(a);



    }


    public static int sum(Integer[] a) {
        int count = 0;
        for(int i = 0; i < a.length; i++) {
            count += a[i];
        }
        return count;
    }
}
