package PreBatch.WeiLai.THREE;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int l = cin.nextInt();
        int r = cin.nextInt();
        Integer[] nums = new Integer[n+1];
        for(int i = 1; i <= n; i++) {
            nums[i] = cin.nextInt();
        }
        nums[0] = -1000000000;
        Arrays.sort(nums,1,nums.length);
        int rr = 1,ll=0,lr=0;
        int result = 0;
        while(rr <= n) {
            while(lr + 1 < rr && nums[rr] - nums[lr+1]>=l) lr++;
            while(ll + 1 <= lr && nums[rr] - nums[ll] > r) ll++;
            if(ll!=0 && lr !=0) result+=lr-ll+1;
            rr++;
        }
        System.out.println(result);
    }
}
