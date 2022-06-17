package _40;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {3,2,4,1,5,8,4,1,1};
        quickSort(nums,0,nums.length-1);
        System.out.println(nums);

    }


    public static void quickSort(int[] arr, int left, int right) {
        //我们就讲左闭右闭好了
        if(left >= right) {
            //说明就剩一个了结束
            return;
        }
        //如果不是那就要开始讲当前的排序
        int temp = arr[left];//我们都默认将最左边的数字作为 中轴
        int start = left;
        int end = right;
        while(end > start) {
            //当重合的时候，就是插入中轴的时候

            //如果都比中轴大，那就不动，遍历
            while(end > start && arr[end] >= temp) {
                end--;
            }
            //到这一步，说明可能找到一个比中轴小的点
            if(end > start) {
                arr[start++] = arr[end];
                //start的位置就是下一个检查的位置，而end因为被赋值过了，所以end位置就是下一个要被填的位置
            }
            //如果都比中轴小，那就不动，遍历
            while(end > start && arr[start] < temp) {
                start++;
            }
            if(end > start) {
                arr[end--] = arr[start];
            }

        }
        //出来了，说明end=start，需要把中轴插入
        arr[end] = temp;

        quickSort(arr,left,end-1);
        quickSort(arr,end+1, right);

    }
}
