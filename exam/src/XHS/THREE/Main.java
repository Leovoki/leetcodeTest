package XHS.THREE;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] rel = new int[n-1];
        for(int i = 0; i < rel.length; i++) {
            rel[i] = cin.nextInt();
        }
        int[][] dp = new int[n+1][2];
        //表示第i个员工为根，有没有朋友的情况下，这棵树的最大朋友对数
        


    }
}

class Person {
    int id;
    Set<Integer> friendIds = new HashSet<>();

    public Person(int i) {
        this.id = i;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Integer> getFriends() {
        return friendIds;
    }

    public void addFriends(Integer id) {
        friendIds.add(id);
    }
}
