package THYC.ONE;

import java.util.HashSet;
import java.util.Set;

public class Main {
    private static Set<Integer> colorSet = new HashSet<>();
    public static void main(String[] args) {

    }

    public static int numColor (TreeNode root) {
        backTracking(root);
        return colorSet.size();

    }

    public static void backTracking(TreeNode node) {
        if(node == null) {
            return;
        }
        colorSet.add(node.val);
        backTracking(node.left);
        backTracking(node.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
