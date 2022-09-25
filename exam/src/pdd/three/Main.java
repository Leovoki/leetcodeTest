package pdd.three;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        cin.nextLine();
        while(t-- > 0) {
            int l = cin.nextInt();//长度
            int m = cin.nextInt();//m个y
            int n = cin.nextInt();//第n小
            String temp  = cin.nextLine();
            String s = cin.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < l; i++) {
                if(s.charAt(i) == 'x') {
                    sb.append('x');
                } else {
                    if(i != 0 && s.charAt(i) == s.charAt(i-1)) {
                        continue;
                    } else {
                        for(int j = 0; j < n-1; j++) {
                            sb.append('y');
                        }
                    }

                }
            }
            System.out.println(sb.toString());

        }
    }
}
