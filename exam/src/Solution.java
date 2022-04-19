import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(7);
        a.add(3);
        a.add(10);
        minMax(a,3,2);
    }

    public static int minMax (ArrayList<Integer> a, int k, int x) {
        List<Integer> list = new ArrayList<>(a);
        PriorityQueue<Integer> que = new PriorityQueue<>(((o1, o2) -> o2-o1));
        for(Integer i : list) {
            que.offer(i);
        }
        while(k-- > 0) {
            Integer num = que.poll();
            num = num - k;
            que.offer(num);
        }

        return que.peek();


    }
}
