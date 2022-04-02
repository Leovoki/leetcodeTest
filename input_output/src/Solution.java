import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] arg) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        //char[] str = new char[n];
        String string = cin.next();
        char[] str = string.toCharArray();//将字符串变成字符数组

        int maxLen = 0;
        int left = 0;
        HashSet<Character> charSet = new HashSet<>();//存放字母，不可重复集合，用来判断当前有多少个不同的字母
        int freq[] = new int[26];//存放字母频率

        for(int right = 0; right < str.length; right++) {
            if(charSet.size() <= k) {
                charSet.add(str[right]);
                freq[str[right] - 'a']++;//char - 'a' = int
            }

            //添加完以后看看集合有没有超标
            while(charSet.size()>k) {
                if(freq[str[left]-'a']==1) {
                    //如果要移除的这个元素只有一个，那么再set里也要移除
                    freq[str[left]-'a']--;
                    charSet.remove(str[left]);
                } else {
                    freq[str[left]-'a']--;
                }
                left++;//做指针移动一位
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        System.out.println(maxLen);


    }
}
