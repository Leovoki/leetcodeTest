package offer07;

class Solution {
    public static void main(String[] args) {
        int[] preorder = {1,4,2,3};
        int[] inorder = {1,2,3,4};
        buildTree(preorder, inorder);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //15:51
        //先序的特性，当前节点一定是第一个
        return build(preorder, inorder,0,inorder.length, 0, preorder.length);

    }

    public static TreeNode build(int[] preorder, int[] inorder,int in_begin,int in_end,int pre_begin,int pre_end) {
        //左闭右开
        if(pre_end == pre_begin) {
            return null;//没有节点可以取
        } else if (pre_end - pre_begin == 1) {
            return new TreeNode(preorder[pre_begin]);//只有一个节点直接返回
        } else if ( pre_begin >= pre_end) {
            return null;
        } else if (pre_begin >= preorder.length) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[pre_begin]);
        int midIndex = getIndex(preorder[pre_begin], inorder, pre_begin, pre_end);

        //左节点
        int left_in_begin = in_begin;
        int left_in_end = midIndex;
        int left_pre_begin = pre_begin+1;
        int left_pre_end = left_pre_begin + (left_in_end - left_in_begin);
        //右节点
        int right_in_begin = midIndex + 1;
        int right_in_end = in_end;
        int right_pre_begin = left_pre_end;
        int right_pre_end = pre_end;

        node.left = build(preorder, inorder, left_in_begin, left_in_end, left_pre_begin, left_pre_end);
        node.right = build(preorder, inorder, right_in_begin, right_in_end, right_pre_begin, right_pre_end);

        return node;

    }

    public static int getIndex(int val, int[] inorder, int start, int end) {
        //左闭右开
        int index = 0;
        for(int i = start; i < end; i++) {
            if(inorder[i] == val) {
                index = i;
                break;
            }
        }
        return index;
    }
}

class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}