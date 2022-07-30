package PreBatch.WeiLai.ONE;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

    public static ListNode mergeNode (ListNode head) {
        if(head == null) return null;
        //确定是偶数
        ListNode p = head;
        ListNode first = head;
        ListNode second = head.next;
        while(p != null) {
          int num = first.val * second.val;
          first.val = num;//用这个节点存储最新值
            p = first;//保留用来断节点
          first = second.next;
          if(first == null) {
              p.next = null;
              break;
          }
          second = first.next;//更新到下一组了

            //断节点
            p.next = first;
        }
        return head;
    }
}

class ListNode {
    int val;
   ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }
