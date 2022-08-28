public class QuickSort {
    public static void main(String[] args) {
        int[] a = {3,8,1,4,0,2,234,2,2341,13,7,6,68,665,57,575,2,2,43,35,5,26,7,54,634};
        quickSort(0,a.length-1,a);
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void quickSort(int start, int end, int[] nums) {
        if(start >= end) return;

        int left = start;
        int right = end;
        int temp = nums[start];//中枢
        while(left < right) {
            while(left < right && nums[right] > temp) {
                right--;
            }
            //找到右边一个解
            if(left < right) {
                nums[left++] = nums[right];//此时右边这个位置孔雀
            }
            while(left < right && nums[left] <= temp) {
                left++;
            }
            if(left < right) {
                nums[right--] = nums[left];
            }
        }
        nums[left] = temp;
        quickSort(start, left-1, nums);
        quickSort(left+1, end, nums);
    }
}

final class Temp {
    private Temp() {

    }
    private static volatile Temp single = null;
    public static Temp getSingle() {
        if(single == null) {
            synchronized(Temp.class) {
                if(single == null) {
                    single = new Temp();
                }

            }
        }
        return  single;
    }
}
