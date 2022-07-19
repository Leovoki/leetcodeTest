package _67;

class Solution {
    public static void main(String[] args) {
        String str =
                "4193 with words";
       System.out.println(strToInt(str)); ;
    }
    public static int strToInt(String str) {
        char[] s = str.trim().toCharArray();
        if (s.length == 0) return 0;
        //返回的是没有空格字符串的字符数组
        int sign = 1;
        int i = 1;
        if(s[0] == '-') sign = -1;
        else if (s[0] != '+') i = 0;

        int res = 0;
        int bndry = Integer.MAX_VALUE / 10;//边界
        for(int j = i; j < s.length; j++) {
            if(s[j] < '0' || s[j] > '9') {
                break;
            }
            //正常数字
            if(res > bndry || res == bndry && s[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (s[j]-'0');
        }
        return sign * res;
    }
}

