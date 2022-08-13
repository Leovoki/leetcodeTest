package MT.QiuZhao.FIVE;

import java.util.Scanner;

public class Main {
    private static Integer maxMoney = 0;
    private static Integer path = 0;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] nodeMoney = new int[n+1];
        for(int i = 1; i <= n; i++) {
            nodeMoney[i] = cin.nextInt();
        }
        getMaxSum(1, nodeMoney, n);
        System.out.println(maxMoney);

    }

    /**
     *
     * @param node 表示第i个节点
     *             nodeMoney[k] 该节点的钱
     *             n总结点数
     * @return
     */
    public static void getMaxSum(int node, int[] nodeMoney, int n) {
        if(node == -1) {
            maxMoney = Math.max(maxMoney, path);
            return;
        }
        path += nodeMoney[node];
        getMaxSum(getChild(node, "left",n), nodeMoney, n);
        getMaxSum(getChild(node, "right",n), nodeMoney, n);
        path -=nodeMoney[node];

    }

    public static int getChild(int node, String s, int n) {
        if(s.equals("left")) {
            if(2*node > n) {
                return -1;
            } else {
                return 2*node;
            }
        } else {
            if(2*node+1 > n) {
                return -1;
            } else {
                return 2*node+1;
            }
        }
    }
}
