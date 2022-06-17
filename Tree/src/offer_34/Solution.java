package offer_34;

import _105.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> result = new ArrayList<>();
    public static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = constructTree(nums);
        pathSum(root, 22);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null) return result;
        find(root, target);
        return result;

    }

    public static void find(TreeNode node, int target) {
        if(node.left == null && node.right == null) {
            if(target - node.val == 0) {
                //找到了
                path.add(node.val);
                result.add(new ArrayList<>(path));//这步不能直接add path,因为加入的只是引用罢了。
                path.remove(path.size()-1);
            }
            return;
        }

        path.add(node.val);
        if(node.left != null) find(node.left, target - node.val);
        if(node.right != null) find(node.right, target - node.val);
        path.remove(path.size()-1);

    }


        public static TreeNode constructTree(Integer[] nums) {
            if (nums.length == 0) return new TreeNode(0);
            Deque<TreeNode> nodeQueue = new LinkedList<>();
            // 创建一个根节点
            TreeNode root = new TreeNode(nums[0]);
            nodeQueue.offer(root);
            TreeNode cur;
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
//                return new TreeNode(0);
//            }
                for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2) {
                    // 说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                    if (i == nums.length) return root;
                    cur = nodeQueue.poll();
                    if (nums[i] != null) {
                        cur.left = new TreeNode(nums[i]);
                        nodeQueue.offer(cur.left);
                    }
                    // 同上，说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                    if (i + 1 == nums.length) return root;
                    if (nums[i + 1] != null) {
                        cur.right = new TreeNode(nums[i + 1]);
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
