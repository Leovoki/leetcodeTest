package nongShang.two;

import java.util.*;

public class Main {
    private static String[] result = null;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m =cin.nextInt();
        Map<Integer,Integer> pos = new HashMap();
        int[] nums = new int[n];
        PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;//从大到小
            }
        });
        for(int i = 0; i < n; i++) {
            int x = cin.nextInt();
            nums[i] = x;
            pos.put(x,i);
            que.add(x);
        }
        result = new String[n];
        int flag = 1;//正的代表A选
        while(!que.isEmpty()) {
            int x = que.poll();
            int index = pos.get(x);
            String c = flag>0 ? "A" : "B";
            result[index] = c;
            que.remove(x);
            nums[index] = -1;
            nums = parseArray(nums, index, m, c, que);
            flag = flag * -1;
        }
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }

    }

    public static int[] parseArray(int[] nums, int index, int m, String c, PriorityQueue<Integer> que) {
        int left = index-1;
        int right = index+1;
        int temp = m;
        //左边
        while(temp-- > 0 && left >= 0) {
            if(left < 0) {
                break;
            }
            while(left >= 0 && nums[left] == -1) {
                left--;
            }
            if(left >= 0) {
                //找到一个解
                que.remove(nums[left]);
                result[left] = c;
                nums[left] = -1;
            }
        }
        temp = m;
        while(temp -- > 0 && right < nums.length) {
            if(right >= nums.length) {
                break;
            }
            while(right < nums.length && nums[right] == -1) {
                right++;
            }
            if(right < nums.length) {
                que.remove(nums[right]);
                result[right] = c;
                nums[right] = -1;
            }
        }
        return nums;
    }
}
