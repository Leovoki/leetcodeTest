package _206reverseLinkList;

public class Test206 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        ListNode p = head;
        for(int i = 1; i <5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        head = reverseList(head);
        System.out.println(head);


    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode after;
        while(cur != null) {
            after = cur.next;
            cur.next = pre;
            pre = cur;
            cur = after;
        }
        return pre;
    }
}
