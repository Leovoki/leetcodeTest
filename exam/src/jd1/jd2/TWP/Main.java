package jd1.jd2.TWP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        String[] numStr = cin.nextLine().split(" ");
        int[] nums = new int[numStr.length];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numStr[i]);
        }
        int count = 0;
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[i-2]) {
                count++;
                nums[i] = nums[i-2];
            }
        }
        System.out.println(count);
    }
}
