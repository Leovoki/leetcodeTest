package jd1.jd2.THREE;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            Scanner cin = new Scanner(System.in);
            long n = cin.nextLong();
            Long[] dp = new Long[(int) n+1];
            //从0~i中已经有两个red后的摆法有几种，这是按照奇数增长的
            //,,除去填满所有都是redred
            //当长度为n的数组，redred有nums种摆法
            Long nums = 2*((n-6))+1;
            //System.out.println(nums);
            double result = 0L;
            for(long i = 1; i <= nums; i++) {
                result = result + Math.pow(26,n-6);
            }
            System.out.printf("%.0f",result);
        }


    }
}
