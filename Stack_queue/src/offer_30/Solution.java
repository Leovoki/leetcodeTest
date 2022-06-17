package src.offer_30;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        //MinStack minStack = new MinStack();
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();
        minStack.pop();
        minStack.top();
        minStack.min();

    }
}

class MinStack {
    Deque<Integer> mainStack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.mainStack = new LinkedList<>();
        this.minStack = new LinkedList<>();

    }

    public void push(int x) {
        mainStack.offerFirst(x);
        minStackPush(x);
    }

    public void pop() {
        mainStack.pollFirst();
        minStackPop();

    }

    public int top() {
        return mainStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public void minStackPush(int x) {
        if(minStack.isEmpty()) {
            minStack.offerFirst(x);
        } else {
            int min = minStack.peek();//peek可以返回Null，getFirst()空值会报错
            min = Math.min(min,x);
            minStack.offerFirst(min);
        }
    }

    public void minStackPop() {
        if(minStack.isEmpty()) {

        } else {
            minStack.pollFirst();
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
