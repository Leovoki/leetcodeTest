package jd1.jd2.ONE;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        int count = k;
        cin.nextLine();
        String s = cin.nextLine();
        char[] str = s.toCharArray();
        for (int i = 0; i < k; i++) {
            if (str[i] >= 'A' && str[i] <= 'Z') {
                //如果已经是大写
                count--;
                continue;
            } else {
                //需要转换
                str[i] = (char) (str[i] - 32);
                count--;
            }
        }
        count = n-k;
        for(int i = str.length-1; i >= 0; i--) {
            if(count > 0) {
                if(str[i] >= 'A' && str[i] <= 'Z') {
                    //是大写
                    str[i] = (char) (str[i] + 32);
                }
            }
            count--;
        }
        for(int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
    }
}
