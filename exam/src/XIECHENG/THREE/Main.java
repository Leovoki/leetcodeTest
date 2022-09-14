package XIECHENG.THREE;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        int n = 0;//数组长度
        int h = 1;
        while(t-- > 0) {
            n = cin.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = cin.nextInt();
            }
            List<Integer> red = new ArrayList<>();
            List<Integer> blue = new ArrayList<>();

            cin.nextLine();
            char[] color= cin.nextLine().toCharArray();
            //分类
            for(int i = 0; i < color.length; i++) {
                if(color[i] == 'R') {
                    red.add(nums[i]);
                } else {
                    blue.add(nums[i]);
                }
            }
            Collections.sort(red);
            Collections.sort(blue);
            Integer redSmall = red.get(0);
            Integer redBig = red.get(red.size()-1);
            Integer blueSmall = blue.get(0);
            Integer blueBig = blue.get(blue.size()-1);
            /*for(int i = 0; i < red.size(); i++) {
                redSmall = Math.min(redSmall, red.get(i));
                redBig = Math.max(redBig, red.get(i));
            }
            for(int i = 0; i < blue.size(); i++) {
                blueSmall = Math.min(blueSmall, blue.get(i));
                blueBig = Math.max(blueBig, blue.get(i));
            }*/
            System.out.println(solution(redBig, redSmall, blueBig, blueSmall));
        }
    }

    public static Integer solution(Integer redBig, Integer redSmall, Integer blueBig, Integer blueSmall) {
        Integer small = Math.min(redSmall, blueSmall);
        Integer big = Math.max(redBig, blueBig);
        if(small == redSmall && big == redBig || small == blueSmall && big == blueBig) {
            //在同一个地方
            return big - small;
        } else {
            //将最小值所在的数组不停的变大，直到该数组的最大值或者最小值小于等于零一数组的最小值和最大值
            if(redSmall < blueSmall) {
                return compare(redSmall, redBig, blueSmall, blueBig);
            } else {
                //这里时需要蓝色的数字减一,似乎没必要比较
                return redBig - blueSmall;
            }
        }
    }
    public static Integer compareBlue(Integer mainSmall, Integer mainBig, Integer otherSmall, Integer otherBig) {
        //蓝色的数字减一
        return 0;
    }

    public static Integer compare(Integer mainSmall, Integer mainBig, Integer otherSmall, Integer otherBig) {
        while(mainSmall < otherSmall && mainBig < otherBig) {
            mainBig++;
            mainSmall++;
        }
        //至少有一个相等了
        if(mainSmall.equals(otherSmall)) {
            return otherBig - mainSmall;
        } else if(mainBig.equals(otherBig)) {
            return otherBig - mainSmall;
        } else {
            return 0;
        }
    }
}
