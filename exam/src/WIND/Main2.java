package WIND;

import java.util.*;

public class Main2 {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Map<Integer,List<TreeNode>> dict = new HashMap<>();
    private static Map<TreeNode, Integer> valueNode = new HashMap<>();
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int k = cin.nextInt();
        cin.nextLine();//去空
        String[] nodeList = cin.nextLine().split(" ");//一行节点
        //构建树

        TreeNode root = constructTree(parseNodeList(nodeList));
        if(root == null) {
            System.out.println();
            return;
        }
        Long start = System.nanoTime();
        //从根节点到其它节点的数值和
        preOrder(root, 0);
        //计算每个子节点作为根节点时，其它节点到该根节点的数值和
        //constructChild(root);

        //遍历一次所有节点，找到目标路径
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            int size = que.size();
            TreeNode node = null;
            for(int i = 0; i < size; i++) {
                node = que.poll();
                List<Integer> path = new ArrayList<>();
                //从根节点到该节点的数值和为curValue
                int curValue = valueNode.get(node);
                int targetValue = curValue + k - node.val - node.level;
                List<TreeNode> targetList = dict.get(targetValue);
                if(targetList == null) {
                    //不操作
                } else {
                    findPath(node, path, targetList);
                }
                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
            }
        }
        for(int i = 0; i < result.size(); i++) {
            List<Integer> path = result.get(i);
            for(int j = 0; j < path.size(); j++) {
                System.out.print(path.get(j));
                if(j != path.size()-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        Long end = System.nanoTime();
        System.out.println(end - start);



        List<Integer> path = new ArrayList<>();

    }

    public static void findPath(TreeNode node, List<Integer> path, List<TreeNode> target) {
        if(node == null) return;

        //查看当前节点是否可以入结果集合
        path.add(node.val);
        for(TreeNode treeNode : target) {
            if(node.equals(treeNode)) {
                result.add(new ArrayList<>(path));
            }
        }
        findPath(node.left, path, target);
        findPath(node.right, path, target);
        path.remove(path.size()-1);

    }

    public static void constructChild(TreeNode root) {
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            int size = que.size();
            TreeNode node = null;
            for(int i = 0; i < size; i++) {
                node = que.poll();
                dfs(node, node, 0, node.childMap);
                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
            }

        }
    }

    public static void dfs(TreeNode root, TreeNode nowNode, int sum, Map<Integer, List<TreeNode>> map) {
        if(nowNode == null) return;

        sum+=nowNode.level + nowNode.val;
        //将当前节点到某根节点的路径值放进该某根节点的childMap中
        List<TreeNode> list = map.getOrDefault(sum, new ArrayList<>());
        list.add(nowNode);
        map.put(sum, list);

        dfs(root, nowNode.left, sum, map);
        dfs(root, nowNode.right, sum, map);

    }

    public static void preOrder(TreeNode node, int sum) {
        if(node == null) return;

        sum+=node.level+ node.val;
        List<TreeNode> treeNodes = dict.getOrDefault(sum, new ArrayList<>());
        treeNodes.add(node);
        dict.put(sum, treeNodes);
        valueNode.put(node, sum);

        preOrder(node.left, sum);
        preOrder(node.right, sum);

    }


    /**
     * 将获取的string节点换成Integer[]数组
     * @param nodeList node string数组
     * @return
     */
    public static Integer[] parseNodeList(String[] nodeList) {
        Integer[] nums = new Integer[nodeList.length];
        for(int i = 0; i < nums.length; i++) {
            if(nodeList[i].equals("null")) {
                nums[i] = null;
            } else {
                nums[i] = Integer.parseInt(nodeList[i]);
            }
        }
        return nums;
    }

    /**
     * 根据nums数组转换为树结构
     * @param nums
     * @return
     */
    public static TreeNode constructTree(Integer[] nums) {
        if (nums.length == 0) return new TreeNode(0, 0);
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        // 创建一个根节点
        TreeNode root = new TreeNode(nums[0], 0);
        nodeQueue.offer(root);
        TreeNode cur;
        // 记录当前行节点的数量（注意不一定是2的幂，而是上一行中非空节点的数量乘2）
        int lineNodeNum = 2;
        // 记录当前行中数字在数组中的开始位置
        int startIndex = 1;
        // 记录数组中剩余的元素的数量
        int restLength = nums.length - 1;
        int level = 1;//除去根节点是0，当前层次的节点level从1开始
        while (restLength > 0) {
            for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2) {
                // 说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i == nums.length) return root;
                cur = nodeQueue.poll();
                if (nums[i] != null) {
                    cur.left = new TreeNode(nums[i], level);
                    nodeQueue.offer(cur.left);
                }
                // 同上，说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i + 1 == nums.length) return root;
                if (nums[i + 1] != null) {
                    cur.right = new TreeNode(nums[i + 1], level);
                    nodeQueue.offer(cur.right);
                }
            }
            startIndex += lineNodeNum;
            restLength -= lineNodeNum;
            lineNodeNum = nodeQueue.size() * 2;
            level++;
        }

        return root;
    }
}


