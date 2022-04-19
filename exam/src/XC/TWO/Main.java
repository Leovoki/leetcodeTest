package XC.TWO;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Map<Integer, List<Integer>> blue = new HashMap<>();
        Map<Integer, List<Integer>> red = new HashMap<>();
        int n = cin.nextInt();
        if(n == 0) {
            System.out.println(0);
        } else {
            int[] nums = new int[n+1];

            for(int i = 0; i < n; i++) {
                nums[i] = cin.nextInt();
            }
            char[] str = cin.next().toCharArray();
            //装填完毕
            for(int i = 0; i < n; i++) {
                if(str[i] == 'B') {
                    List list = blue.getOrDefault(nums[i],new ArrayList<>());
                    list.add(i);//将这个数字的下标存进去
                    blue.put(nums[i],list);
                } else {
                    List list = red.getOrDefault(nums[i],new ArrayList<>());
                    list.add(i);//将这个数字的下标存进去
                    red.put(nums[i],list);
                }
            }

            //遍历
            int res = 0;
            for(int i = 0; i < n; i++) {
                char color = str[i];
                if(color == 'R') {
                    List list = blue.getOrDefault(nums[i], new ArrayList<>());//找和这个数字一样的下标
                    res = res + list.size();

                } else {
                    List list = red.getOrDefault(nums[i], new ArrayList<>());//找和这个数字一样的下标
                    res = res + list.size();
                }
            }
            System.out.println(res/2);
        }


    }
}
