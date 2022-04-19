package jd1.One;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        if(t == 0) {
            System.out.println();
        }
        List<String> result = new ArrayList<>();
        while(t-- > 0) {
            int n = cin.nextInt();
            String flag = "Yes";
            Stack<String> que = new Stack<>();
            cin.nextLine();
            while(n-- > 0) {
                String[] str = cin.nextLine().split(" ");
                if(flag.equals("No")) continue;
                if(str[0].equals("end")) {
                    String top = que.pop();
                    if (!top.equals(str[1])) {
                        flag = "No";
                    }
                } else {
                    que.push(str[0]);
                }
            }
            if(!que.isEmpty()) {
                flag = "No";
            }
            result.add(flag);
        }
        for(String s : result) {
            System.out.println(s);
        }
    }
}
