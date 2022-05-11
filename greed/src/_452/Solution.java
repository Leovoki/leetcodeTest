package _452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[][] points = {{-22,-21},{2147483645,2147483646}};
        findMinArrowShots(points);

    }
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);//用compare不会有内存溢出的问题
            }
        });

        int start = Integer.MIN_VALUE;
        int end = Integer.MAX_VALUE;
        int count = 1;
        for(int i = 0; i < points.length; i++) {
            if(points[i][0] <= end) {
                //这是一个可行的解
                start = points[i][0];
                if(end > points[i][1]) {
                    end = points[i][1];
                }
            } else {
                //冒出一个新的解
                count++;
                start = points[i][0];
                end = points[i][1];
            }

        }
        return count;
    }
}
