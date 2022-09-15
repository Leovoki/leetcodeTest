package GuangLianDa.one;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        cin.nextLine();
        while(t-- > 0) {
            char[] s = cin.nextLine().toCharArray();
            Deque<Character> que = new LinkedList<>();
            int first = 1;//表示下一个轮到1先手，-1后手的人
            for(int i = 0; i < s.length; i++) {
                if(que.isEmpty()) {
                    //空，直接放
                    que.push(s[i]);
                } else {
                    char c = que.peek();
                    if(c == s[i]) {
                        //发生一次消除
                        first = first * -1;
                        que.poll();
                    } else {
                        que.push(s[i]);
                    }
                }
            }
            //全部结束
            //说明下一个人是后手，说明后手一直在等待操作
            if(first == -1) {
                //且下一个后手，则先手赢
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }
}
