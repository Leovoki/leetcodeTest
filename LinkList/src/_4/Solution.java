package _4;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        findMedianSortedArrays(nums1, nums2);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        boolean odd = false;
        if((size1+size2) % 2 != 0) {
            odd = true;//奇数
        }
        double result = 0;
        int targetCount = (size1+size2)/2;//中位数的第一个位置
        List<Integer> nums = new ArrayList<>();
        int first = 0;
        int second = 0;
        while(first < size1 && second < size2) {
            //两个数组都有东西的时候
            if(nums1[first] <= nums2[second]) {
                nums.add(nums1[first++]);
            }
            if(nums1[first] > nums2[second]) {
                nums.add(nums2[second++]);
            }
        }
        if(first == size1) {
            //第一个满了
            while(second < size2) {
                nums.add(nums2[second++]);
            }
        } else {
            while(first < size1) {
                nums.add(nums1[first++]);
            }
        }
        //数组按顺序排序完毕
        if(odd) {
            //如果是奇数
            return (double)nums.get(targetCount);
        } else {
            return ((double)nums.get(targetCount-1) + (double)nums.get(targetCount)) / 2;
        }
        //return 0;
    }
}
