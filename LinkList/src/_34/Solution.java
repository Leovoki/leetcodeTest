package _34;

/**
 * @author Leovoki
 * @version 1.0 update on 2022/6/28
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,2};
        int target = 3;
        System.out.println(searchRange(nums, target));

    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if(nums.length == 0) {
            return result;
        }
        int left = 0;
        int right = nums.length-1;
        //左闭右闭
        int mid = 0;
        //先找开始位置
        while(left < right) {
            mid = (left + right) >>> 1;
            if(nums[mid] > target) {
                right = mid-1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;//因为永远是向下取整的，right=mid不会死循环
            }
        }
        //最终结果有可能是错位的，但是left会在正确的位置上
        if(nums[left] == target) {
            result[0] = left;//这里只能写left,不然惠溢出
        } else {
            return result;
        }
        //如果起始位置找不到就不要走到这一步
        //结束位置
        left = 0;
        right = nums.length-1;
        while(left < right) {
            mid = (left + right+1) >>> 1;
            if(nums[mid] > target) {
                right = mid-1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                left = mid;//因为二分法是向下取证，那mid可能永远是left，导致死循环，所以这里我们使用上取整。
            }
        }
        if(nums[left] == target) {
            result[1] = left;
        }
        return result;
    }
}
