package _77;

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
        System.out.println(combine(4,2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        find(n, k, 1);
        return ans;


    }


    public static void find(int n, int k, int startIndex) {
        if(path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i <= n; i++) {
            if(n - (i + 1) + 1 < k - path.size()) {
                continue;
            }
            path.add(i);
            find(n, k, i + 1);
            path.remove(path.size()-1);
        }
    }
}
