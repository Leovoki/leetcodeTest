package MAYI.THREE;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        char[] s = cin.nextLine().toCharArray();
        int size = s.length;
        //Set<String> strSet = new HashSet<>();
        long count = 0;
        //将单独的字符计算一遍
        for(int i = 0; i < size; i++) {
            count++;
        }
        //先通过dp计算每个子串是否

        for(int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s[i]);
            Set<Character> isOdd = new HashSet<>();
            isGood(s, i, isOdd);
            for(int j = i+1; j < size; j++) {
                sb.append(s[j]);
                isGood(s, j, isOdd);
                //每次都需要判断是否是好字符
                if(isOdd.size() == 1) {
                    //说明只有一个字符是奇数
                    count++;
                }
            }

        }
        System.out.println(count);
    }

    private static void isGood(char[] s, int i, Set<Character> isOdd) {
        if(isOdd.add(s[i])) {
            //原本没有就是true
        } else {
            //说明原本有
            isOdd.remove(s[i]);
        }
    }
}
