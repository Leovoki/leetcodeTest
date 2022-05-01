package _1323;

public class Solution {
    public static void main(String[] args) {
        int num = 969969;
        System.out.println(maximum69Number(num));
    }

    public static int maximum69Number (int num) {
        //首先数字要尽可能的长
        //变动的9要尽可能的早
        Integer number = num;
        String s = number.toString();
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++) {
            if(str[i] == '6') {
                str[i] = '9';
                break;
            }
        }

        number = Integer.parseInt(new String(str));
        return number;

    }


}
