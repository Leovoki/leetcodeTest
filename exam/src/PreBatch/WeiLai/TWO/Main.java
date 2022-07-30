package PreBatch.WeiLai.TWO;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin  = new Scanner(System.in);
        int n = cin.nextInt();
        int l = cin.nextInt();
        int r = cin.nextInt();
        Integer[] nums = new Integer[n];
        for(int i = 0; i < n; i++) {
            nums[i] = cin.nextInt();
        }
        Arrays.sort(nums);
        int first = 0;
        int end = nums.length-1;
        int result = 0;//答案
        int diff = 0;
        int flag = -1;//说明是第一次遇到合适的
        boolean out = false;
        for(int i = 0; i < nums.length; i++) {
            if(out) break;
            for(int j = flag==-1?i+1:flag; j < nums.length; j++) {
                diff = nums[j] - nums[i];
                if(isBest(l, r, diff) == 0) {
                    if(flag == -1) {
                        flag = j;
                    }
                    result++;
                } else if (isBest(l,r,diff) == -1) {
                    //说明差距小
                    if(j == nums.length-1) {
                        out = true;
                    }
                    continue;
                } else {
                    break;
                }
            }
        }
        System.out.println(result);
    }


    /**
     * -1 小
     * 0 是的
     * 1 大
     * @param l
     * @param r
     * @param num
     * @return
     */
    public static int isBest(int l, int r, int num) {
        if(num < l) {
            return -1;
        } else if (num > r) {
            return 1;
        } else {
            return 0;
        }
    }

}
