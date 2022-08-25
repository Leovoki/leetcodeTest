package HW.ONE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] assets = new int[n];
        for(int i = 0; i < n; i++) {
            assets[i] = cin.nextInt();
        }
        int money = cin.nextInt();
        Arrays.sort(assets);
        //以每一个人的资产作为出发点。查看差额是多少。只去满足他之前的人，达到同一高度后，再判断还有没有剩余
        Map<Integer,Solution> result = new HashMap<>();//key:个数，value:剩余
        result.put(1, new Solution(1,-1,money));
        for(int i = 0; i < n; i++) {
            allocateMoneyBefore(n, assets, i, money, result);
        }
        int maxPeople = 1;
        int minRest = money;
        for(Map.Entry<Integer,Solution> entry : result.entrySet()) {
            if(entry.getKey() > maxPeople) {
                maxPeople = entry.getKey();
                minRest = entry.getValue().getMinRest();
            } else {
                continue;
            }
        }
        System.out.println(maxPeople + " " + minRest);


    }

    /**
     *
     * @param n
     * @param assets
     * @param index 以第几个为标准
     * @return
     */
    public static void allocateMoneyBefore(int n, int[] assets, int index, int money, Map<Integer,Solution> map) {
        //System.out.println("正在计算" + index);
        int biggest = assets[index];//当前最大值
        //从后往前匹配
        int count = 1;
        int rest = money;//剩余
        int[] copyAssets = Arrays.copyOf(assets, n);
        for(int i = index-1; i >= 0; i--) {
            if(assets[index] - assets[i] <= rest) {
                //钱如果够减
                rest-= assets[index] - assets[i];
                copyAssets[i] = assets[index];
                count++;
            }
        }
        Solution solution = new Solution();
        if(rest == 0) {
            //刚好结束
            solution.setMaxPeople(count);
            solution.setMinRest(0);
            solution.setAvgMoney(assets[index]);
            //map.put(count, map.getOrDefault(count,Integer.MAX_VALUE) > rest ? rest : map.getOrDefault(count,Integer.MAX_VALUE));//放最优解进去

        } else if (rest > 0) {
            //找到分配到的点
            int pos = findPos(copyAssets, index);
            //说明前排所有人都已经平均过了
            int times = rest / (index-pos+1);//看看能分几次
            if(times > 0) {
                //说明还能分
                rest -= times * (index-pos+1);
            } else {
                //原来就没有全部分完，所以不用计算了
            }
            solution.setMaxPeople(count);
            solution.setMinRest(rest);
            solution.setAvgMoney(assets[index] + times);
            //map.put(count, map.getOrDefault(count,Integer.MAX_VALUE) > rest ? rest : map.getOrDefault(count,Integer.MAX_VALUE));

        }
        if(count == 1) return;
        setSolution(count, map, solution);

    }

    public static void setSolution(int count, Map<Integer, Solution> map, Solution solution) {
        Solution oldSolution = map.get(count);
        if(oldSolution == null) {
            map.put(count, solution);
        } else {
            if(oldSolution.getMaxPeople() != solution.getMaxPeople()) {
                //人数不一样
                map.put(count, oldSolution.getMaxPeople() > solution.getMaxPeople() ? oldSolution : solution);
            } else if(oldSolution.getAvgMoney() != solution.getAvgMoney()) {
                //人数一样，则看谁的资产多
                map.put(count, oldSolution.getAvgMoney() > solution.getAvgMoney() ? oldSolution : solution);
            } else {
                //剩余少的，是最好的
                map.put(count, oldSolution.getMinRest() > solution.getMinRest() ? solution : oldSolution);
            }
        }
    }

    public static int findPos(int[] copyAssets, int start) {
        for(; start >= 1; start--) {
            if(copyAssets[start] == copyAssets[start-1]) continue;
            else break;
        }
        return start;
    }

}
class Solution {
    int maxPeople;
    int avgMoney;
    int minRest;

    public Solution() {

    }

    public Solution(int maxPeople, int avgMoney, int minRest) {
        this.maxPeople = maxPeople;
        this.avgMoney = avgMoney;
        this.minRest = minRest;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getAvgMoney() {
        return avgMoney;
    }

    public void setAvgMoney(int avgMoney) {
        this.avgMoney = avgMoney;
    }

    public int getMinRest() {
        return minRest;
    }

    public void setMinRest(int minRest) {
        this.minRest = minRest;
    }
}