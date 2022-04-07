package src._1047;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        String s = "abbaca";
        removeDuplicates(s);
    }


    public static String removeDuplicates(String s) {
        Deque<Character> que = new LinkedList<>();
        int size = s.length();
        for(int i = 0; i < size; i++) {
            if(que.isEmpty()) que.offerFirst(s.charAt(i));
            if(que.peek() == s.charAt(i)) {
                que.pollFirst();
            } else {
                que.offerFirst(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!que.isEmpty()) {
            sb.append(que.pollLast());
        }
        return new String(sb);
    }
}