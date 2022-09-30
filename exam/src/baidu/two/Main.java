package baidu.two;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4,5,2,6,8,3,1};
        quickSort(nums,0,nums.length-1);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }


    }

    public static void quickSort(int[] nums, int start, int end) {
        //左闭右闭
        if(start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int temp = nums[start];

        while(left < right) {
            while(left < right && nums[right] >= temp) {
                right--;
            }
            if(left < right) {
                //可能解
                nums[left++] = nums[right];
            }
            while(left < right && nums[left] <= temp) {
                left++;
            }
            if(left < right) {
                nums[right--] = nums[left];
            }
        }
        nums[left] = temp;
        quickSort(nums, start, left-1);
        quickSort(nums,left+1, end);
    }
}


