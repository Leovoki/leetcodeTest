package _714;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {
                1,3,2,8,4,9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));

    }
    public static int maxProfit(int[] prices, int fee) {
        int curDiff = 0;
        int preDiff = 0;
        int havePrice = 0;
        int earn = 0;
        for(int i = 0; i < prices.length-1; i++) {
            curDiff = prices[i+1] - prices[i];

            if(curDiff > 0 && preDiff <= 0) {
                //说明是谷点
                if(havePrice == 0) {
                    havePrice = prices[i];
                }
                preDiff = curDiff;

            } else if (curDiff < 0 && preDiff >= 0) {
                //高点
                if(havePrice != 0) {
                    //有货
                    if(prices[i] <= havePrice + fee) {
                        preDiff = curDiff;
                        continue;//没意义
                    }
                    earn = earn + havePrice - prices[i] - fee;
                    havePrice = 0;
                }
                preDiff = curDiff;
            } else {
                //说明保持现有状态
            }
        }
        return earn;
    }
}
