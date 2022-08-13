package MT.QiuZhao.THREE;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] a = new int[n+1];
        for(int i = 1; i <=n; i++) {
            a[i]= cin.nextInt();
        }
        Deque<Integer> que = new LinkedList<>();
        que.offerFirst(a[n]);
        for(int i = n-1; i >= 1; i--) {
            que.offerFirst(a[i]);
            que.offerFirst(que.pollLast());
            que.offerFirst(que.pollLast());

        }
        boolean flag = false;
        while(!que.isEmpty()) {
            if(flag) {
                System.out.printf(" ");
            } else {
                flag = true;
            }
            System.out.printf("%s",que.peekFirst());
            que.pollFirst();

        }

    }
}
