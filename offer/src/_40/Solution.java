package _40;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {3,2,4,1,5,8,4,1,1};
        int k = 2;
        int[] result = quickSort(arr, 0, arr.length-1, k);
        //int[] result = quickSort2(arr, k, 0, arr.length-1);
        System.out.println(result);

    }

    public static int[] quickSort(int[] arr, int left, int right, int k) {
        //我们就讲左闭右闭好了
        //核心是把比你小的放左边，比你大的放右边，那么跟你一模一样的可以不动

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
            while(end > start && arr[start] <= temp) {
                start++;
            }
            if(end > start) {
                arr[end--] = arr[start];
            }

        }
        //出来了，说明end=start，需要把中轴插入
        arr[end] = temp;

        //这时候需要判断中轴
        if(end > k) {
            //说明前面还要接着排序
            return quickSort(arr,left,end-1,k);
        } else if(end < k){
            //说明要增大范围,前面的几个数肯定是前k个小的。但现在要继续找到后面几个小的数，所以从中轴位置开始找
            return quickSort(arr,end+1, right, k);
        }

        return Arrays.copyOf(arr,k);


    }

    private static int[] quickSort2(int[] arr, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > k) return quickSort2(arr, k, l, i - 1);
        if (i < k) return quickSort2(arr, k, i + 1, r);
        return Arrays.copyOf(arr, k);
    }
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
