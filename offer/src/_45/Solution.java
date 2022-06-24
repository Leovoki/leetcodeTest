package _45;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(minNumber(nums));
    }

    public static String minNumber(int[] nums) {
        Integer[] s = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
            s[i] = nums[i];
        }
        quickSort(0,nums.length-1, s);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length; i++) {
            sb.append(s[i]);
        }
        return sb.toString();
    }

    public static void quickSort(int left, int right, Integer[] nums) {
        //左闭右闭策略
        if(left >= right) {
            return;
        }
        Integer temp = nums[left];//以此为基准
        int start = left;
        int end = right;
        while(start < end) {
            while(start < end && (nums[end].toString() + temp.toString()).compareTo(temp.toString() + nums[end].toString())>=0) {
                end--;
                //这里说明的是当右边的数和中枢拼接，大于中枢和右边拼接，则不动
            }
            if(start < end) {
                nums[start++] = nums[end];
            }
            while(start < end && (nums[start].toString() + temp.toString()).compareTo(temp.toString() + nums[start].toString()) <=0) {
                start++;
            }
            if(start < end) {
                nums[end--] = nums[start];
            }
        }
        //说明重合了
        nums[start] = temp;
        quickSort(left,end-1,nums);
        quickSort(end+1, right, nums);

    }
}
