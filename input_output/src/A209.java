import java.util.ArrayList;
import java.util.List;

public class A209 {
    public static void main(String[] arg) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target,nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minSize = nums.length;
        int left = 0;
        int sum = 0;
        List<Integer> ans = new ArrayList<>();
        for(int fast = 0; fast < nums.length;fast++) {
            sum = sum + nums[fast];
            ans.add(nums[fast]);
            while(sum >= target) {
                minSize = Math.min(minSize, ans.size());
                sum = sum - ans.get(0);
                ans.remove(0);
            }
        }
        if(minSize == nums.length) {
            return 0;
        } else {
            return ans.size();
        }


    }
}
