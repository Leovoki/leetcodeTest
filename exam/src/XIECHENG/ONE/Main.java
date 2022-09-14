package XIECHENG.ONE;

import java.util.Scanner;

public class Main {
    private static double minAbs = Integer.MAX_VALUE;
    private static double result = 0;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();//边长
        int k = cin.nextInt();//刀数
        int row = k;//横着切的次数
        int col = 0;//竖着切的次数
        for(col = 0; col <= k; col++) {
            row = k- col;
            findAnswer(row,col, (double) n, k);
        }
        System.out.printf("%.2f", result);


    }
    public static void findAnswer(int row, int col, double n, int k) {
        double chang;
        double kuan;
        //每个矩形的长
        if(col == 0) {
            //没有竖切
            chang = n;
            kuan = n / (row+1);
        } else if (row == 0) {
            //没有横切
            chang = n / (col+1);
            kuan = n;
        } else {
            //都有
            chang = n / (col+1);
            kuan = n / (row+1);
        }
        if(minAbs > Math.abs(chang - kuan)) {
            //有效解
            minAbs = Math.abs(chang - kuan);
            result = chang * kuan;
        }
    }
}
