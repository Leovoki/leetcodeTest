package _3;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }


    public static int lengthOfLongestSubstring(String s) {
        //不用map的做法
        if (s == null) return 0;
        Set<Character> set = new HashSet<>();
        int fast = 0;
        int slow = 0;
        char[] str = s.toCharArray();
        //int[] freq = new int[26];
        int result = 0;
        int nowLength = 0;
        for (fast = 0; fast < s.length(); fast++) {
            if (!set.add(str[fast])) {
                //有重复
                nowLength++;//先放进去
                while (str[slow] != str[fast]) {
                    set.remove(str[slow++]);
                    nowLength--;
                }
                //一旦等于
                nowLength--;
                slow++;

            } else {
                nowLength++;
            }
            result = Math.max(result, nowLength);
        }
        return result;

    }

}
