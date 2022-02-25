package _450;

import publicTool.ConstructTree;
import publicTool.TreeNode;

import java.util.List;

public class DeleteNode {
    public static void main(String[] args) {
        Integer[] list = {5,3,6,2,4,null,7};
        TreeNode root = ConstructTree.constructTree(list);
        deleteNode(root, 3);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        delete(root,key);
        return root;
    }

    public static TreeNode delete(TreeNode node, int key) {
        if(node == null) return null;


        if(node.val == key) {
            if(node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                TreeNode left = node.right;
                while(left != null) {
                    if(left.left == null) {
                        break;
                    } else {
                        left = left.left;
                    }
                }
                left.left = node.left;
                node = node.right;
            }
            return node;
        }

        if(node.val > key) {
            node.left = delete(node.left,key);
        } else {
            node.right = delete(node.right,key);
        }
        return node;
    }
}
