package MeiDi.TWO;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        String[] s = cin.nextLine().split(",");
        for(int i = 0; i < s.length; i++) {
            set.add(Integer.parseInt(s[i]));
        }

        int result = Integer.MIN_VALUE;
        Iterator<Integer> it = set.iterator();
        List<Integer> list = new ArrayList<>();
        while(it.hasNext()) {
            list.add(it.next());
        }
        for(int i = 0; i < list.size(); i++) {
            for(int j = i+1; j < list.size(); j++) {
                result = Math.max(result, list.get(i) * list.get(j));
            }
        }
        System.out.println(result);
    }
}

