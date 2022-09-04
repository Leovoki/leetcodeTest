public class JustBinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12 ,9};
        System.out.println(search(nums, 9));

    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid-1;
            } else if (nums[mid] < target) {
                left = mid+1;
            } else {
                break;
            }
        }
        if(nums[mid] == target) {
            return mid;
        } else {
            return -1;
        }
    }
}
