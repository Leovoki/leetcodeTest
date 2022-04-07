package src._150;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Deque<String> que = new LinkedList<>();
        int size = tokens.length;
        for(int i = 0; i < size; i++) {
            if(isNumber(tokens[i])) {
                que.offerFirst(tokens[i]);
            } else {
                Integer b = Integer.parseInt(que.pollFirst());
                Integer a = Integer.parseInt(que.pollFirst());
                Integer res = calculate(a,b, tokens[i]);
                que.offerFirst(res.toString());
            }
        }
        return Integer.parseInt(que.pollFirst());

    }

    public static boolean isNumber(String s) {
        if(s == "/" || s == "+" || s == "*" || s == "-") {
            return false;
        } else {
            return true;
        }
    }

    public static int calculate(int a, int b, String s) {
        if(s == "/") {
            return a/b;
        } else if ( s == "*") {
            return a*b;
        } else if (s == "+") {
            return a + b;
        } else {
            return a - b;
        }
    }
}