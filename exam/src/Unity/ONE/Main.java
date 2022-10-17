package Unity.ONE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        //System.out.println(rob(nums));

    }

    public static int rob(int[] nums) {
        if(nums.length <= 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        //前i个房子，最多可以偷窃dp[i]
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        //List<Integer> result =(List<Integer>) dp;
        return dp[nums.length-1];
    }
}
