package _39;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Leovoki
 * @version 1.0 update on 2022/3/2
 */
public class Solution {
    static List<List<Integer>> ans = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();


    public static void main(String[] args) {
        //StringBuilder builder = new StringBuilder("apple");

        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //int sum = 0;
        Arrays.sort(candidates);
        backTracking(candidates, target,0,0);
        return ans;

    }


    public static void backTracking(int[] candidates, int target, int startIndex,int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;

            path.add(candidates[i]);
            backTracking(candidates, target, i, sum + candidates[i]);
            //sum-=candidates[i];
            path.remove(path.size()-1);


        }
    }
}
