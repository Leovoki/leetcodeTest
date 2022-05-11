package _406;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(people);

    }
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> {
            if(a[0] != b[0]) return b[0] - a[0];
            else return a[1] - b[1];
        });
        Arrays.sort(people, (a,b) -> {
            if(a[0] != b[0]) return b[0] - a[0];
            else return a[1] - b[1];
        });
        //先按照身高从高到低排列，然后呢按照前面的个数来排
        //身高最高的其实已经是有序的了。
        LinkedList<int[]> que = new LinkedList<>();
        for(int[] item : people) {
            que.add(item[1],item);
        }
        return que.toArray(new int[people.length][]);



    }
}
