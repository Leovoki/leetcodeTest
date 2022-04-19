package _03;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }

    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) {
                repeat = nums[i];
                break;
            }
        }
        return repeat;
    }

    public static int findRepeatNumber2(int[] nums) {
        int repeat = 0;
        //因为里面的数字都是0~n-1的
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == i) {
                //判断位置是否正确，如果正确则不管
                continue;
            } else {
                //不正确，那就把这个值，放在本来应该放的位置
                //nums[i]本来应该放在下标为nums[i]的位置上，
                int temp = nums[nums[i]];
                if(temp == nums[i]) {
                    //如果本来正确的位置上已经有正确的值了，现在【不同位置】处有两个相同的数字，那就说明有重复数字
                    repeat = temp;
                    break;
                }
                nums[nums[i]] = nums[i];
                nums[i] = temp;
                //位置调换
            }
        }
        return repeat;
    }
}
