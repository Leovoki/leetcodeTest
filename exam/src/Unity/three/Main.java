package Unity.three;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        String s = "(((*)";
    }
    private static boolean isP = true;
    public static boolean isValidString(String s) {
        char[] str = s.toCharArray();
        Deque<Character> que = new LinkedList<>();
        for(int i = 0; i < str.length; i++) {
            if(str[i] == '(') {
                que.offerFirst(str[i]);
            } else if (str[i] == ' ') {
                continue;
            } else if (str[i] == ')') {
                parseA(que);
            } else {
                que.offerFirst('*');
            }
            if(!isP) {
                break;
            }
        }
        if(!isP) {
            return false;
        }
        int cnt = 0;
        for(int i = 0; i < que.size(); i++) {
            //？
        }
        if(que.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void parseA(Deque<Character> que) {
        int xing = 0;
        while(!que.isEmpty()) {
            if(que.peekFirst() == '*') {
                que.pollFirst();
                xing++;
            } else if(que.peekFirst() == ')') {
                if(xing > 0) {
                    xing--;
                    while(xing-- > 0) {
                        que.offerFirst('*');
                    }
                } else {
                    isP = false;
                }
                break;
            } else if (que.peekFirst() == '(') {
                que.pollFirst();
                break;
            }
        }
        if(xing > 0) {
            //说明都用掉了
            xing--;
            while(xing-- > 0) {
                que.offerFirst('*');
            }
        }
    }
}
