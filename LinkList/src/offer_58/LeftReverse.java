package offer_58;

import java.util.ArrayList;
import java.util.List;

public class LeftReverse {
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseLeftWords(s,2));

    }

    public  static String reverseLeftWords(String s, int n) {
        char[] str = s.toCharArray();
        List<Character> a = new ArrayList();
        int firstIndex = 0;
        int slowIndex = 0;
        for(;firstIndex < str.length; firstIndex++) {
            if(firstIndex < n ) {
                a.add(str[firstIndex]);
            } else {
                str[slowIndex] = str[firstIndex];
                slowIndex++;
            }
        }
        if(slowIndex > s.length() - 1) {
            return s;
        }

        int j = 0;
        for(int i = slowIndex; i < str.length; i ++) {
            str[i] = a.get(j);
            j++;
        }
        return new String(str);

    }
}
