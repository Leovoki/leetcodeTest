package Unity.two;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }


    private static Integer maxValue = 0;
    public static int solve(int n, ArrayList<Interval> Tree_edge, ArrayList<Integer> Edge_value) {
        //数组存节点的边，转换为图遍历
        List<int[]>[] map = new ArrayList[n];

        for(int j = 0; j < n; j++) {
            map[j] = new ArrayList<>();
        }

        for(int i = 0; i < Tree_edge.size(); i++) {
            map[Tree_edge.get(i).start].add(new int[]{Tree_edge.get(i).end, Edge_value.get(i)});
            map[Tree_edge.get(i).end].add(new int[]{Tree_edge.get(i).start, Edge_value.get(i)});
        }

        //深搜
        int k = n;
        dfs(map, new boolean[k], 0);
        return maxValue;



    }

    public static int dfs(List<int[]>[] map, boolean[] visited, int index) {
        visited[index] = true;
        List<int[]> list = map[index];

        int weighta = 0;
        int weightb = 0;
        for(int[] childWeight : list) {
            int child = childWeight[0];
            int weight = childWeight[1];
            if(visited[child]) {
                continue;
            }

            int sum_weight = weight + dfs(map, visited, child);
            if(sum_weight > weighta) {
                weightb =weighta;
                weighta = sum_weight;
            } else if (sum_weight > weightb) {
                weightb = sum_weight;
            }
            if(weighta + weightb > maxValue) {
                maxValue = weighta + weightb;
            }
        }
        return Math.max(weightb, weighta);
    }

    class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


}
