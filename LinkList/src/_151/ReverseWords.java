package _151;

import java.util.Stack;

public class ReverseWords {
    public static void main(String[] arg) {
        String s = "the sky is blue ";
        System.out.println(reverseWords(s));
    }




    public static String reverseWords(String s) {
        char[] str = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Stack<String> stack = new Stack<>();
        Stack<Character> spaceStack = new Stack<>();
        boolean isFront = true;
        for(int i = 0; i < str.length; i++) {
            if(str[i] == ' ') {
                if(stringBuilder.length() > 0) {
                    stack.push(stringBuilder.toString());
                    stringBuilder.delete(0,stringBuilder.length());
                }
                continue;
            }
            stringBuilder.append(str[i]);
        }
            if(stringBuilder.length() > 0) {
                stack.push(stringBuilder.toString());
            }

        String ans = new String();
        int stackSize = stack.size();
        for(int i = 0; i < stackSize; i++) {
            if(i==stackSize-1) {
                ans = ans + stack.pop();
                break;
            }
            ans = ans + stack.pop() + " ";
        }
        return ans;
    }
}


