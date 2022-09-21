package MeiDi.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String[] s = cin.nextLine().split(",");
        for(int i = 0; i < s.length; i++) {
            list.add(Integer.parseInt(s[i]));
        }

        int result = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++) {
            for(int j = i+1; j < list.size(); j++) {
                result = Math.max(result, list.get(i) * list.get(j));
            }
        }
        System.out.println(result);
    }
}
