package MAYI.TWO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static long count = 0;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        List<List<Integer>> tree = new ArrayList<>();
        List<Integer> value = new ArrayList<>();//权值
        List<Integer> number = new ArrayList<>();//编号
        for(int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
            value.add(1);
            number.add(0);
        }


        for(int i = 0; i < n-1; i++){
            int index = cin.nextInt();
            int v = cin.nextInt();
            tree.get(index).add(v);
        }
        //获取了所有的节点之间的关系
        dfs_tree(tree, value, 1);
        System.out.println(count);



    }

    public static void dfs_tree(List<List<Integer>> tree, List<Integer> value, int curNode) {
        //遍历每一个节点
        int childValue;
        for(int child : tree.get(curNode)) {
            childValue = value.get(child);
            if(child - childValue > 0) {
                //如果还需要增加则
                count = count + child -childValue;
                dfs_add(tree, value, child -childValue, child);
            } else {

            }
            dfs_tree(tree, value, child);//继续遍历这个树

        }
    }

    public static void dfs_add(List<List<Integer>> tree, List<Integer> value, int addValue, int curNode) {
        for(int child : tree.get(curNode)) {
            //获取当前节点的所有子节点，child表示子节点的编号
            value.set(child, value.get(child) + addValue);
            dfs_add(tree, value, addValue, child);
        }
    }
}
