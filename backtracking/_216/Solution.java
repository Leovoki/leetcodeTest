package _216;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leovoki
 * @version 1.0 update on 2022/3/1
 */
public class Solution {
    private static List<List<Integer>> ans = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();

    public static void main(String[] args){
        System.out.println(combinationSum3(3,7));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        find(k,n,1,0);
        return ans;
    }


    public static void find(int k, int n, int startIndex, int sum) {
        if(path.size() == k) {
            if(sum == n) {
                ans.add(new ArrayList<>(path));
                return;
            } else {
                return;
            }
        }

        for(int i = startIndex; i <= 9; i ++) {
            path.add(i);
            sum += i;
            if(sum > n) {
                path.remove(path.size()-1);
                return;
            }
            find(k, n, i+1, sum);
            path.remove(path.size()-1);
            sum = sum - i;

        }
    }
}
