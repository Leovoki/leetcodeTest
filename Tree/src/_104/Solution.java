/*
package _104;


public class Solution {
    private static Integer maxAns = 0;
    private static Integer deep = 0;
    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,1};
        TreeNode root = ConstructTree.constructTree(nums);
        if(root != null) preOrder(root);
        System.out.println(maxAns);

    }

    public static void preOrder(TreeNode node) {
        deep++;
        if(node == null) {
            deep--;
            if(deep > maxAns) maxAns = deep;
            return;
        }

        if(deep > maxAns) maxAns = deep;

        preOrder(node.left);
        preOrder(node.right);
        deep--;
    }



}
*/
