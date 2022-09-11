package LeTian.one;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] A = {3,3,3};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int result =0;
        //可以先记录摆动的情况
        int[] move = new int[A.length-1];
        for(int i = 0; i < A.length-1; i++) {
            move[i] = A[i+1] - A[i];
        }
        int curCount = 1;
        for(int i = 0; i < move.length-1; i++) {
            if(move[i+1] * move[i] > 0) {
                curCount++;
            } else {
                if(curCount % 2 == 1) {
                    //奇数
                    result += curCount/2;
                } else {
                    result += curCount;
                }
                curCount = 1;
            }
        }
        return result;

    }
    public static int parse(int[] move, int count, int result) {
        if(count % 2 == 1) {
            //奇数
            return result + count/2;
        } else {
            return count;
        }
    }
}
