package GuangLianDa.tow;

import java.util.Scanner;

public class Main {
    private static boolean isContinue = true;
    private static int cost = 0;//花费
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int k = cin.nextInt();//k版
        //贪心，每次先且一块下来，需要判断是横着切还是竖着切
        //只切短的
        int count = 1;//当前的b版数，默认已经有一版了
        //只要版数没到要求就循环继续切
        while(count < k && isContinue) {
            if(n >= m) {
                count = cut(n, m, count, k);
                n = n-1;
            } else {
                count = cut(m,n,count,k);
                m = m-1;
            }
        }
        System.out.println(cost);
    }
    public static int cut(int longer, int shorter, int count, int target) {
        cost = cost + shorter*shorter;//一次切，花费就是短*短
        count++;//于是就多了一版
        while(shorter > 1 && count < target) {//把切出来的一条，开始一个个的分割
            count++;//切一次，多一版
            shorter--;//可切长度-1
            cost++;//因为都是切一刀，所以花费+1
        }
        //跳出
        if(count == target) {
            isContinue = false;//不用切了
        } else {
            return count;
        }
        return 0;


    }
}
