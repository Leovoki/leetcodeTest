package _151;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ResizeArray {
    public static void main(String[] args) {
        String s = " hello world ";
        System.out.println(reverseWords(s));

    }

    public static String reverseWords(String s) {
        char[] str = s.toCharArray();
        reverse(str,0,str.length-1);
        s = new String(str);
        //1.清除多余空格
        s = eraseExtraSpace(s);
        str = s.toCharArray();

        int front = 0;
        int end = 0;
        for(end = 0; end < str.length; end++) {
            if(str[end] == ' ') {
                reverse(str,front,end - 1);
                front = end + 1;
            } else if (end == str.length -1) {
                reverse(str,front,end);
            }
        }
        return new String(str);
    }

    public static String eraseExtraSpace(String s) {
        char[] str = s.toCharArray();
        int size = str.length;
        int slowIndex = 0;
        int fastIndex = 0;
        //解决开头的空格
        Boolean isFront = true;
        for(slowIndex = 0; fastIndex < size; fastIndex++) {
            if(str[fastIndex] != ' ' && isFront) {
                isFront = false;
                str[slowIndex] = str[fastIndex];
                slowIndex++;
            } else if (isFront && str[fastIndex] == ' ') {
                continue;
            } else {
                str[slowIndex] = str[fastIndex];
                slowIndex++;
            }
        }
        s = new String(str,0,slowIndex);


        //解决中间的空格
        slowIndex = 0;
        fastIndex = 0;
        str = s.toCharArray();
        size = s.length();
        for(;fastIndex < size; fastIndex++) {
            if(str[fastIndex] == ' ' && str[fastIndex] == str[fastIndex-1]) {
                continue;
            } else {
                str[slowIndex] = str[fastIndex];
                slowIndex++;//如果不删除，slowIndex是超出数组一格
            }
        }
        s = new String(str,0,slowIndex);

        //解决末尾的空格
        size = s.length();
        slowIndex = size-1;
        fastIndex = size-1;
        for(; fastIndex > -1; fastIndex--) {
            if(str[fastIndex] == ' ') {
                continue;
            } else {
                break;
            }
        }
        s = new String(str,0,fastIndex+1);//count计算的是末尾+1
        return s;


    }

    public static void reverse(char[] str, int front, int end) {

        for(; front < end; front++) {
            char temp = str[end];
            str[end] = str[front];
            str[front] = temp;
            end--;
        }
    }
}
