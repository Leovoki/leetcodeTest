package MT.TWO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int maxCash = 1000000;//最大持有现金
        int cashHave = 999000;
        int n = cin.nextInt();
        int[] price = new int[n];
        for(int i = 0; i < n; i++) {
            price[i] = cin.nextInt();
        }
        //贪心，每次只要有收益我就赚，反正没手续费
        for(int i = 1; i < n; i++) {
            int num = 0;//买多少一次
            int diff = price[i] - price[i-1];
            if(diff > 0) {
                //只要shi赚的
                //买多少一次
                num = cashHave/price[i-1];
                if(cashHave + (diff) * num >= maxCash) {
                    cashHave = findMaxPoint(price,i-1, cashHave);
                    break;
                } else {
                    cashHave = cashHave + (diff)*num;//没到一百万，就算个差值
                }
            }
        }
        System.out.println(cashHave);

    }

    public static int findMaxPoint(int[] price,int start,int cashHave) {
        //找最大差值，在这里直接计算
        //以start为起点或者以100万为起点两种
        Map<String,Integer> map = new HashMap<>();
        int diff = 0;
        int beforeEarn = 0;
        int afterEarn = 0;
        boolean flag = true;
        for(int i = start; i < price.length; i++) {
            for(int j = i+1; j < price.length; j++) {
                if(price[j] - price[i] > diff) {
                    if(i != start) flag = false;//说明不是起点的算法了，且有最大值
                    diff = price[j] - price[i];
                    map.put("max",price[j]);
                    map.put("min",price[i]);
                }
            }
            if(flag && diff > 0) {
                //说明有起点的情况
                diff = map.get("max") - map.get("min");
                int num = cashHave/map.get("min");
                beforeEarn = cashHave + num*diff;
            }
            flag = false;
        }


        if(flag) {
            return beforeEarn;
        } else {
            //说明有非起点的情况
            diff = map.get("max") - map.get("min");
            int num = 1000000/map.get("min");
            afterEarn = 1000000 + num * diff;
            return Math.max(afterEarn, beforeEarn);
        }


    }

}
