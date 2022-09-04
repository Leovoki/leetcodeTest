package _3;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int fast = 0;
        int slow = 0;
        char[] str = s.toCharArray();
        int[] freq = new int[26];
        int result = 0;
        for(fast = 0; fast < s.length();fast++) {
            if(!set.add(str[fast])) {//如果set存在，则会返回false
                //有重复
                freq[str[fast]-'a']++;
                while(freq[str[fast]-'a'] > 1) {
                    freq[str[slow]-'a']--;
                    if(freq[str[slow]-'a'] == 0) {
                        //说明删光了
                        set.remove(str[slow]);
                    }
                    slow++;
                }
            } else {
                freq[str[fast]-'a']++;
                result = Math.max(result, set.size());
            }
        }
        return result;

    }
}