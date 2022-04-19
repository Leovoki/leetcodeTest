package _215;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {

    }


    public static int findKthLargest(int[] nums, int k) {
        IntStream stream = Arrays.stream(nums);
        Stream<Integer> integerStream = stream.boxed();

        Integer[] integers = integerStream.toArray(Integer[]::new);

        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int ans = 0;
        return integers[k - 1];
    }
}

