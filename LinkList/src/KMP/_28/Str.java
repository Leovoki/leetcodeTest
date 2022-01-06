package KMP._28;

public class Str {
    public static void main(String[] args)
    {
        String haystack = "aabaabacaaqqqqqqqqqqqqqq";
        String needle = "asdfasdfasdf";
        //System.out.println(strStr(haystack,needle));
        strStr(haystack,needle);

    }

    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) {
            return 0;
        }
        int[] next = getNext(needle);
        int j = 0;
        for(int i = 0; i < haystack.length(); i++) {
            while(j>0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j-1];
            }
            if(haystack.charAt(i) == needle.charAt(j)) j++;
            if(j == needle.length()) {
                return (i-needle.length()+1);
            }
        }
        return -1;


    }


    public static int[] getNext(String needle) {
        int size = needle.length();
        char[] str = needle.toCharArray();
        int[] next = new int[size];
        int j = 0;
        next[0] = 0;
        for(int i = 1; i < size; i++) {//i从1开始，一前一后的开始比较
            while(j>0 && str[i] != str[j]) {
                j = next[j-1];
            }
            if(str[i] == str[j]) j++;
            next[i] = j;
        }
        for(int i = 0; i < next.length; i++) {
            System.out.println(next[i] + " ");
        }
        return next;

    }
}
