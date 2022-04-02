import java.util.HashMap;
import java.util.Map;

public class A1 {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(twoSum(nums, target));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> pos = new HashMap<>();
        int[] ans = new int[2];

        for(int i = 0; i < nums.length; i++) {
            if(pos.get(nums[i]) == null) {
                pos.put(nums[i],i);
            } else {
                continue;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if(pos.containsKey(res)) {
                ans[0] = i;
                ans[1] = pos.get(res);
                return ans;
            }
        }
        return ans;
    }
}
