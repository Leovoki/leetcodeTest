package baidu.three;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    private static Boolean isP = true;
    public static void main(String[] args) {
        String s = "([[]])";

        char[] str = s.toCharArray();
        Deque<Character> que = new LinkedList<>();
        for(int i = 0; i < str.length; i++) {
            if(str[i] == '(' || str[i] == '[' || str[i] == '{') {
                que.offerFirst(str[i]);
            } else {
               parse(str[i], que);
            }
            if(!isP) {
                break;
            }

        }
        if(que.isEmpty()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static void parse(char s, Deque<Character> que) {
        if(s == ']') {
            if(que.peekFirst().equals('[')){
                que.pollFirst();
            } else {
                isP = false;
            }

        } else if(s == ')') {
            if(que.peekFirst().equals('(')){
                que.pollFirst();
            } else {
                isP = false;
            }
        } else {
            if(que.peekFirst().equals('{')){
                que.pollFirst();
            } else {
                isP = false;
            }
        }
    }


}
