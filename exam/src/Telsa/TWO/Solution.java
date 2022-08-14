package Telsa.TWO;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    private static int max = 0;
    public static void main(String[] args) {
        int[] a = {10, -8, -3, -1, 10};
        int[] b = {-1,3,-2,3,-5,80};
        int[] c = {10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10,10, -10, -1, -1, 10};
        System.out.println(solution(c));
    }

    public static int solution(int[] A) {
        int size = A.length;
        backTracking(size, 0,0, A,0);
        return size - max;

    }

    /**
     *
     * @param size
     * @param sum 当前收入和债务的总额
     * @param number 当前累计的次数
     * @param A
     * @param startIndex
     */
    public static void backTracking(int size, int sum, int number, int[] A, int startIndex) {
        if(sum >= 0) {
            max = Math.max(max, number);
        } else {
            return;
        }
        for(int i = startIndex; i < size; i++) {
            backTracking(size, sum+A[i], number+1, A, i+1);
        }

    }

    /*public static int solution(int[] A) {
        // write your code in Java SE 8
        //归根到底就是计算，从那一下标出发,能够在过程中不出现负数
        int size = A.length;
        int[] cost = new int[size];
        int[] earn = new int[size];
        for(int i = 0; i < size; i++) {
            if(A[i] <= 0) {
                cost[i] = -A[i];
            } else {
                cost[i] = 0;
            }
            if(A[i] >= 0) {
                earn[i] = A[i];
            } else {
                earn[i] = 0;
            }
        }

        int start = 0;
        int curSum = 0;
        for(int i = 0; i < size; i++) {
            curSum = earn[i] - cost[i];
            if(curSum < 0) {
                start = i+1;
                curSum = 0;
            }
        }
        return start;

    }*/
}
