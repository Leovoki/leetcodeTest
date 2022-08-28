package XH.TWO;

import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        //System.out.println(1);
        //都是整数数组，互不相等
        //是不是二叉搜索树
        //是不是这棵树的后序遍历结果
        //5，7，6，9，11，10，8
        int[] nums = {5,7,6,9,11,10,8};
        System.out.println(checkTree(nums, 0, nums.length-1));




    }

    public static boolean checkTree(int[] nums, int start, int end) {
        //左闭右闭
        if(start >= end) {
            return true;
        }
        int root = nums[end];
        int midIndex = 0;
        for(int i = 0; i < end; i++) {
            if(nums[i] < root) {
                continue;
            } else {
                //找到第一个比他大的
                midIndex = i;
                break;
            }
        }
        //判断后半部分是否符合条件
        for(int i = midIndex; i < end; i++) {
            if(nums[i] < root) {
                return false;
            }
        }
        boolean left = checkTree(nums, start, midIndex-1);
        boolean right = checkTree(nums, midIndex, end-1);
        return left && right;

    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
