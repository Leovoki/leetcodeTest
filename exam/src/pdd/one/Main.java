package pdd.one;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //街区要越多，猫粮用的要越少
    private static Integer streetResult = -1;
    private static Integer foodsResult = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();//街区数量
        int m = cin.nextInt();//猫粮
        int[] cats = new int[n+1];//都从下标为1开始
        for(int i = 1; i <= n; i++) {
            cats[i] = cin.nextInt();
        }
        //街区关系,每一个街区拥有的子节点,
        List<List<Integer>> streets = new ArrayList<>();
        streets.add(new ArrayList<>());//0下标空值
        for(int i = 1; i <= n; i++) {
            streets.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++) {
            int x = cin.nextInt();
            int y = cin.nextInt();
            streets.get(x).add(y);
            streets.get(y).add(x);
        }
        dfs(streets, cats[1], 1, 1, cats, m-cats[1], -1);
        if(streetResult.equals(-1)) {
            System.out.println(0 + " " + 0);
        } else {
            System.out.println(streetResult + " " + foodsResult);
        }

    }
    public static void dfs(List<List<Integer>> streets, Integer nowFood, Integer nowStreet, Integer cur, int[] cats, int haveFoods, int fa) {
        if(haveFoods < 0) {
            return;
        }
        //凡是有个解就看看
        if(haveFoods >= 0) {
            if(nowStreet > streetResult) {
                streetResult = nowStreet;
                foodsResult = nowFood;
            } else if(nowStreet == streetResult) {
                //街区数量一样，但是食物更少
                if(nowFood < foodsResult) {
                    foodsResult = nowFood;
                }
            }
        }
        //叶子节点结束遍历
        if(streets.get(cur) == null || streets.get(cur).size() == 0) {
            return;
        }

        for(Integer child : streets.get(cur)) {
            if(child == fa) {
                continue;
            }
            int needFoods = cats[child];
            dfs(streets, nowFood+ needFoods, nowStreet+1, child, cats, haveFoods - needFoods, cur);
        }
    }
}
