package _151;

/**
 * @author Leovoki
 * @version 1.0 update on 2022/6/28
 */
public class Offer58 {
    public static void main(String[] args) {
        String s = " hello    word ";
        System.out.println(reverseWords(s));

    }

    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();

        //清除前后的空格
        int size = s.length();
        int start = 0;
        while(start < size && s.charAt(start) == ' ') {
            start++;
        }
        int end = s.length()-1;
        while(end > -1 &&s.charAt(end) == ' ') {
            end--;
        }
        //停留在第一个字符
        if(start > end) return "";
        s = s.substring(start, end+1);
        char[] str = s.toCharArray();
        //先全部反转
        reverse(0, s.length()-1, str);
        //局部单词反转
        start = 0;
        for(end = 0; end < s.length(); end++) {
            if(end != 0 && str[end] == ' ' && str[end-1] != ' ') {
                //说明是区分处
                reverse(start,end-1,str);
                res.append(str,start, end-start);
                res.append(' ');
                start = end+1;
            } else if (end == s.length()-1) {
                reverse(start, end, str);
                res.append(str,start, end-start+1);
                break;
            } else if (str[end] != ' ') {
                continue;
            } else if(str[end] == ' ' && str[end-1] == ' '){
                //连续空格,说明start至少是下一个
                start = end + 1;
            }

        }
        return res.toString();

    }

    public static void reverse (int start, int end, char[] str) {
        for(start = start; start < end;) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            end--;
            start++;
        }
    }
}
