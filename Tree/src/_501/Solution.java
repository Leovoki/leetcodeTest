package _501;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    static Integer maxCount = 0;
    static Integer count;
    static TreeNode1 pre;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Integer[] nums = {1,null,2,2};
        TreeNode1 root = ConstructTree1.ConstructTree1(nums);
        findMode(root);


    }

    //private List<Integer> list = new ArrayList<>();
    public static int[] findMode(TreeNode1 root) {
        count(root);
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer num : list) {
            res[i++] = num;
        }

        return res;


    }

    public static void count(TreeNode1 node) {
        if (node == null) {
            return;
        }
        count(node.left);
        if (pre != null) {
            if (pre.val == node.val) {
                count++;
            } else if (count > maxCount) {
                //当前这个是个新数字
                    //算是个最大的数字
                    list.clear();
                    list.add(pre.val);
                    maxCount = count;
                } else if (count == maxCount) {
                    //也是众数
                    list.add(pre.val);
                } else {
                    //不是
                    count = 1;
                }

        } else {
            count=1;//如果是第一个节点
        }
        pre = node;
        count(node.right);
    }
}


class ConstructTree1 {
    public static TreeNode1 ConstructTree1(Integer[] nums) {
        if (nums.length == 0) return new TreeNode1(0);
        Deque<TreeNode1> nodeQueue = new LinkedList<>();
        // 创建一个根节点
        TreeNode1 root = new TreeNode1(nums[0]);
        nodeQueue.offer(root);
        TreeNode1 cur;
        // 记录当前行节点的数量（注意不一定是2的幂，而是上一行中非空节点的数量乘2）
        int lineNodeNum = 2;
        // 记录当前行中数字在数组中的开始位置
        int startIndex = 1;
        // 记录数组中剩余的元素的数量
        int restLength = nums.length - 1;

        while (restLength > 0) {
            // 只有最后一行可以不满，其余行必须是满的
//            // 若输入的数组的数量是错误的，直接跳出程序
//            if (restLength < lineNodeNum) {
//                System.out.println("Wrong Input!");
//                return new TreeNode1(0);
//            }
            for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2) {
                // 说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i == nums.length) return root;
                cur = nodeQueue.poll();
                if (nums[i] != null) {
                    cur.left = new TreeNode1(nums[i]);
                    nodeQueue.offer(cur.left);
                }
                // 同上，说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i + 1 == nums.length) return root;
                if (nums[i + 1] != null) {
                    cur.right = new TreeNode1(nums[i + 1]);
                    nodeQueue.offer(cur.right);
                }
            }
            startIndex += lineNodeNum;
            restLength -= lineNodeNum;
            lineNodeNum = nodeQueue.size() * 2;
        }

        return root;
    }
}

class TreeNode1 {
    public int val;
    public TreeNode1 left;
    public TreeNode1 right;

    public TreeNode1() {
    }

    public TreeNode1(int val) {
        this.val = val;
    }

    public TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
