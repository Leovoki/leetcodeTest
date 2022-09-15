package MAYI.ONE;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        Deque<Character> que = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(que.isEmpty()) {
                que.push('a');
            } else {
                parseWhile(que, 'a');
            }
        }
        while(!que.isEmpty()) {
            System.out.print(que.pollLast());
        }

    }

    public static void parseWhile(Deque<Character> que, Character input) {
        if(que.isEmpty()) {
            que.push(input);
        } else {
            if(que.peekFirst() == input) {
                //如果一样、则弹出
                que.poll();
                input = (char) ((int) input + 1);
                parseWhile(que, input);
            } else {
                que.push(input);
            }
        }
    }
}
