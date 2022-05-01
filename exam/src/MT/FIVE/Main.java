package MT.FIVE;

import java.util.*;

public class Main {
    static Deque<Integer> que = new LinkedList<>();
    static Map<Integer,Integer> now = new HashMap<>();
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        int m = cin.nextInt();

        while(m-- > 0) {//m次操作
            String ops = cin.next();
            int time = cin.nextInt();
            int num = cin.nextInt();
            if(ops.equals("add")) {

            }

        }
    }

    public static void add(int num,int n, int time) {
        que.offerLast(num);
        Set<Map.Entry<Integer, Integer>> entrySet = now.entrySet();
            //没有运行
        now.put(num,time);
        for(Map.Entry s  : entrySet) {
            System.out.println(s.getKey());
        }

    }

    public static void query() {
        System.out.println(now);
    }
}
