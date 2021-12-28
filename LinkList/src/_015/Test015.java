package _015;

import _707.MyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Leovoki
 * @version 1.0 update on 2021/11/26
 */
public class Test015 {
    public static void main(String[] args) {
        int[] nums = {1,2,-2,-1};
        System.out.println(threeSum(nums));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int first = 0; first < n; first++) {
            if(first > 0 && nums[first] == nums[first-1]) {
                continue;
            }
            int third = n-1;
            int target = -nums[first];
            for(int second = first+1; second < third; second++) {
                if(second > first+1 && nums[second]==nums[second-1]) {
                    continue;
                }
                while(nums[second] + nums[third] > target && second<third) {
                    third--;
                }
                if(nums[first] + nums[second] + nums[third] == 0 && second<third) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[first]);
                    ans.add(nums[second]);
                    ans.add(nums[third]);
                    res.add(ans);
                }
            }
        }
        return res;
    }
}
