package xiaomi.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int result = 0;
        int start = 0;
        int end = 0;
        int curStart = -1;
        int curEnd = -1;
        String s = null;
        int[] days = new int[10000000];
        boolean over = false;
        while((s = cin.nextLine()) != null) {
            if(s.equals("")) break;
            start = Integer.parseInt(s.split(" ")[0]);
            end = Integer.parseInt(s.split(" ")[1]);
            for(int i = start; i < end; i++) {
                days[i-1]++;
            }
        }

        for(int i : days) {
            if(i > 0) {
                result++;
            }
        }
        System.out.println(result);
    }
}
