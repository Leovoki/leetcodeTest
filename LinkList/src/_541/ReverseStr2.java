package _541;

public class ReverseStr2 {
    public static void main(String[] args)
    {
        String s = "abcdefg";
        System.out.println(reverseStr(s,2));
    }

    public static String reverseStr(String s, int k) {
        int end = s.length()-1;
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i+=2*k) {

            str = reverseK(str,i,k);
        }
        return new String(str);
    }

    public static char[] reverseK(char[] s, int start, int k) {
        int end = start + k -1;
        if(end > s.length-1) {
            end = s.length - 1;
        }
        for(int i = start; i <= end; i++) {
            char temp = s[i];
            s[i] = s[end];
            s[end] = temp;
            end--;
        }
        return s;
    }
}
