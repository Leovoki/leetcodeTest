package offer_58;

//不申请额外空间
public class LeftReverse2 {
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseLeftWords(s,2));

    }

    public static String reverseLeftWords(String s, int n) {
        if(n == 0) {
            return s;
        } else if (n == s.length()-1) {
            return s;
        } else if (s.length() == 0) {
            return s;
        }
        char[] str = s.toCharArray();
        reverse(str,0, str.length-1);
        reverse(str,0,str.length-n-1);
        reverse(str, str.length-n, str.length-1);
        return new String(str);

    }

    public static void reverse(char[] str, int front, int end) {

        for(; front < end; front++) { //这里是小于end
            char temp = str[end];
            str[end] = str[front];
            str[front] = temp;
            end--;
        }
    }
}
