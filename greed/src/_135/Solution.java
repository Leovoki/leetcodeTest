package _135;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] ratings = {
                1,2,87,87,87,2,1};
        //String temp =  String.join(",",String.valueOf(ratings[0]),String.valueOf(ratings[0]));
        //char[] temp1 = temp.toCharArray();

        List<int[]> list = new ArrayList<>();
        System.out.println(candy(ratings));

    }

    public static int candy(int[] ratings) {
        int size = ratings.length;
        int[] candies = new int[size];
        int count = 0;
        for(int i = 0; i < size; i++) {
            candies[i] = 1;
        }


        for(int i = 0; i < size-1; i++) {
            if(ratings[i] > ratings[i+1]) {
                //左边的比右边的大，那么左边的就应当加1
                candies[i]++;
            }
        }

        for(int i = 1; i < size; i++) {
            //判断他的左边跟你的大小
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            } else if(ratings[i] == ratings[i-1]){
                candies[i] = candies[i-1];
            }
        }
        for(int i = 0; i < size; i++) {
            count  = count +candies[i];
        }
        return count;
    }
}
