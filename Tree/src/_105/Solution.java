/*
package _105;

*/
/**
 * @author Leovoki
 * @version 1.0 update on 2022/2/22
 *//*

public class Solution {
    public static void main(String[] args) {
        int[] preOrder = {1,2};
        int[] inOrder = {1,2};
        System.out.println(build(preOrder, inOrder, 0, preOrder.length, 0, inOrder.length));
    }

    public static TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if(preRight - preLeft == 0) return null;

        int nodeVal = preorder[preLeft];
        TreeNode node = new TreeNode(nodeVal);

        if(preRight - preLeft == 1) return node;

        int splitIndex;
        for(splitIndex = inLeft; splitIndex < inRight; splitIndex++) {
            if(inorder[splitIndex] == node.val) {
                break;
            }
        }

        int left_inLeft = inLeft;
        int left_inRight = splitIndex;
        int right_inLeft = splitIndex + 1;
        int right_inRight = inRight;

        int left_preLeft = preLeft + 1;
        int left_preRight = (left_inRight - left_inLeft) + left_preLeft;
        int right_preLeft = left_preRight;
        int right_preRight = preRight;

        for(int i = left_inLeft; i < left_inRight; i++) {
            System.out.println(inorder[i] + ";");
        }
        System.out.println("\n");

        for(int i = left_preLeft; i < left_preRight; i++) {
            System.out.println(preorder[i] + ";");
        }
        System.out.println("\n");

        for(int i = right_inLeft; i < right_inRight; i++) {
            System.out.println(inorder[i] + ";");
        }
        System.out.println("\n");

        for(int i = right_preLeft; i < right_preRight; i++) {
            System.out.println(preorder[i] + ";");
        }
        System.out.println("\n");

        System.out.println("-----------------------------");

        node.left = build(preorder, inorder, left_preLeft, left_preRight, left_inLeft, left_inRight);
        node.right = build(preorder, inorder, right_preLeft, right_preRight, right_inLeft, right_inRight);

        return node;
    }
}
*/
