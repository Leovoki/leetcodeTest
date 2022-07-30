package PreBatch.XingHuan.ONE;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {5,3,4,4,7,3,6,11,8,5,11};
        System.out.println(totalSteps(nums));
    }

    public static int totalSteps (int[] nums) {
        ListNode last = new ListNode(0);
        ListNode cur = last;
        Deque<ListNode> que = new LinkedList<>();
        int size = nums.length;
        for(int i = size-1; i >=0; i--) {
            //int num = nums[i];
            ListNode node = new ListNode(nums[i]);
            node.next = cur;
            cur = node;//倒序链表
            if(cur.next!=last && cur.val > cur.next.val) {
                que.offerLast(cur);
            }
        }
        int count = 0;
        while(!que.isEmpty()) {
            count++;
            size = que.size();
            for(int i = 0; i < size; i++) {
                ListNode node = que.pollFirst();
                node.next = node.next.next;
                if(node.next!=last && node.val > node.next.val) {
                    que.offerLast(node);
                }
            }

        }
        return count;
    }


}

class ListNode {
    ListNode next;
    int val;
    public ListNode(int x) {
        this.val  = x;
    }
}
