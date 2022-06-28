package _491;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leovoki
 * @version 1.0 update on 2022/3/3
 */
public class Solution {
    static List<List<Integer>> ans = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {4,4,3,2,1};
        System.out.println(findSubsequences(nums));
    }


    public static List<List<Integer>> findSubsequences(int[] nums) {
        int[] used = new int[101];
        backTracking(nums, 0, used);
        return ans;

    }


    public static void backTracking(int[] nums, int stratIndex, int[] used) {



        for(int i = stratIndex; i < nums.length; i++) {
            if(used[nums[i]] == 1) {
                continue;
            }
            if(path.size() == 0) {
                path.add(nums[i]);
            } else if(nums[i] >= path.get(path.size()-1)) {
                path.add(nums[i]);
                ans.add(new ArrayList<>(path));
            }
            used[nums[i]] = 1;

            backTracking(nums, i+1, new int[101]);
            path.remove(path.size()-1);
        }
    }
}
