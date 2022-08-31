package THYC.THREE;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private static List<Set<Integer>> path = new ArrayList<>();
    private static Integer minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] nums = {6,3,8,1,3,1,2,2};
        int k = 4;
        System.out.println(minimumIncompatibility(nums, k));
    }
    public static int minimumIncompatibility (int[] nums, int k) {
        if(nums.length % k != 0) {
            return -1;
        }
        int[] used = new int[nums.length];
        backTracking(nums, k, used, new HashSet<>());
        return minDiff.equals(Integer.MAX_VALUE) ? -1 : minDiff;
    }

    public static void backTracking(int[] nums, int k,int[] used, Set<Integer> nowSet) {
        if(path.size() == k || (path.size() == k-1 && nowSet.size() == nums.length/k)) {
            minDiff = Math.min(minDiff, check(nowSet));
            //path.remove(path.size()-1);//移除
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i] == 1) {
                continue;
            }
            //到里面来的，说明这个数字肯定是还没有用过的
            if(nowSet.size() == nums.length/k) {
                //说明满了
                path.add(nowSet);
                nowSet = new HashSet<>();
            }
            if(!nowSet.add(nums[i])) {
                //说明有重复的
                continue;
            } else {
                used[i] = 1;
            }
            used[i] = 1;
            backTracking(nums, k, used, nowSet);
            used[i] = 0;
            if(nowSet.size() == 0) {
                //说过说已经是0了
                nowSet = path.get(path.size()-1);
            }
            nowSet.remove(nums[i]);
        }
    }

    public static Integer check(Set<Integer> nowSet) {
        int sum = 0;
        for(Set<Integer> set : path) {
            sum = getSum(set, sum);
        }
        sum += getSum(nowSet, sum);
        return sum;
    }

    private static int getSum(Set<Integer> nowSet, int sum) {
        if(nowSet.size() == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(Integer num : nowSet) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        sum+=(max - min);
        return sum;
    }
}
