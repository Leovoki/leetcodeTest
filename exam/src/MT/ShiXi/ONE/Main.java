package MT.ShiXi.ONE;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        //String[] str = new String[n];
        String s = cin.next();
        char[] str = s.toCharArray();

        int ans = 0;
        if(n%2 == 0) {
            ans = Math.min(getNum(false,n,str),getNum(true,n,str));
        } else {
            int cntC = 0;
            int cntJ = 0;
            for(int i = 0; i < n; i++) {
                if(str[i] == 'C') cntC++;
                else cntJ++;
            }
            if(Math.abs(cntC-cntJ) > 1) {
                System.out.println(-1);
                return;
            }
            if(cntC > cntJ) {
                ans = getNum(false,n,str);
            } else {
                ans = getNum(true,n,str);
            }
        }
        System.out.println(ans);

    }

    public static int getNum(boolean start, int n, char[] str) {
        int p = 0;
        if(!start) {
            p = 1;
        }
        int ans = 0;
        int countJ = 0;
        for(int i = 0; i < n; i++) {
            if(str[i] == 'J') {
                countJ++;
                ans = ans + Math.abs(p-i);
                p = p + 2;
            }
        }
        if(Math.abs(n-countJ-countJ) > 1) {
            ans = -1;
        }
        return ans;
    }
}
