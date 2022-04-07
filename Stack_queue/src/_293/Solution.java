package src._293;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums,3);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> que = new LinkedList<>();
        MyQueue maxQue = new MyQueue();
        for(int i = 0; i < k; i++) {
            que.offerFirst(nums[i]);
            maxQue.push(nums[i]);
        }
        int count = 0;
        res[count++] = maxQue.front();;

        for(int i = k; i < nums.length; i++) {
            //去除末尾，更新最大值
            maxQue.pop(que.pollLast());
            //加入最新值，更新最大值
            que.offerFirst(nums[i]);
            maxQue.push(nums[i]);

            //此时为完整的一次滑动过程
            res[count++] = maxQue.front();
        }
        return res;

    }
}

class MyQueue {
    Deque<Integer> queue;
    public MyQueue () {
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        while(!queue.isEmpty() && x > queue.peekLast()) {
            queue.pollLast();
        }
        queue.offerLast(x);

    }


    public Integer front() {
        return queue.peek();
    }

    public void pop(int x) {
        if(queue.peek().equals(x)) {
            queue.pollFirst();
            //最大的该走了，使用时间到了
        }
    }
}
