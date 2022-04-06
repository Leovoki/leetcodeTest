package src;

import java.util.Deque;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(5);
        deque.offerFirst(6);
        deque.pollFirst();
    }
}
