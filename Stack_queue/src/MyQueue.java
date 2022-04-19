package src;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyQueue {

    public void function() {
        Stack<Integer> a = new Stack<>();
        Deque<Integer> deque = new LinkedList<>();
        a.push(5);
        a.peek();
        a.pop();
        deque.poll();
        deque.offer(1);
        
        deque.offer(1);
    }
}
