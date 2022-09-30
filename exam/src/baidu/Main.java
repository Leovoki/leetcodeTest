package baidu;

public class Main {
    public static void main(String[] args) {
        int m = 2;
        int[] nums = {1,2,3,4,5};

        Linked head = new Linked(nums[0]);
        Linked p = head;
        for(int i = 1; i < nums.length; i++) {
            Linked node = new Linked(nums[i]);
            p.next = node;
            p = node;
        }
        p.next = head;
        p = head;
        while(p.next != p) {
            int n = m;
            Linked pre = p;
            for(int i = 0; i < n-1; i++) {
                pre = p;
                p = p.next;
            }
            pre.next = p.next;
            p = pre.next;
        }
        System.out.println(p.val);

    }
}

class Linked {
    int val;
    Linked next;

    public Linked(int val) {
        this.val = val;
    }

    public Linked() {

    }
}
