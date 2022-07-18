import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {
    public static void main(String[] args) {
        String s = "aadadaad";
        System.out.println(firstUniqChar(s));
        System.out.println(3*0.1 == 0.3 ? "true" : "false");
        ConcurrentHashMap<String,String> mmap = new ConcurrentHashMap();
        mmap.put("name","张三");
        mmap.get("name");
        List<Integer> myList = new ArrayList<>();
        myList.add(100);
        myList.add(200);
        myList.set(0,100);
        StringBuilder sb = new StringBuilder();
        char[] str = {'a','p','p','l','e'};
        sb.append(str,1,3);
        System.out.println("sb = " + sb);


    }
    public static char firstUniqChar(String s) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        int[] freq = new int[27];
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++) {
            freq[str[i]-'a']++;
            set.add(str[i]);
        }
        Iterator<Character> i = set.iterator();
        while(i.hasNext()) {
            char c = i.next();
            if(freq[c-'a'] == 1) {
                return c;
            }

        }
        return ' ';
    }
}
