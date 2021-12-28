package _707;

/**
 * @author Leovoki
 * @version 1.0 update on 2021/10/21
 */
public class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode p = head;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.val;

    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        if (size == 0) {
            head.next = node;
            size++;
        } else {
            node.next = head.next;
            head.next = node;
            size++;
        }

    }

    public void addAtTail(int val) {
        ListNode p = head;
        while(p.next != null) {
            p = p.next;
        }
        p.next = new ListNode(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
        } else if (index > size) {
            return;
        } else if (index < 0) {
            addAtHead(val);
        } else {
            ListNode p = head;
            for(int i = 0; i < index; i++) {
                p = p.next;
            }
            ListNode node = new ListNode(val) ;
            node.next = p.next;
            p.next = node;
            size++;

        }
    }

    public void deleteAtIndex(int index) {
        if (index < size) {
            ListNode p = head;
            for(int i = 0; i < index; i++ ) {
                p = p.next;
            }
            p.next = p.next.next;
            size--;
        }

    }
}
