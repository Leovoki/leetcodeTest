package MeiDi.THREE;

import java.util.*;

public class Main {
    private static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        char[] s = cin.nextLine().toCharArray();
        StringBuilder sb = null;
        List<String> result = new ArrayList<>();
        for(int i = 0; i < s.length; i++) {
            sb = new StringBuilder();
            for(int j = i+1; j < s.length; j++) {
                sb = sb.append(s[i]);
                sb.append(s[j]);
                if(set.add(sb.toString())) {
                    //说明不重复
                    result.add(sb.toString());
                }
                sb = new StringBuilder();
                sb.append(s[j]);
                sb.append(s[i]);
                if(set.add(sb.toString())) {
                    //说明不重复
                    result.add(sb.toString());
                }
                sb = new StringBuilder();

            }
        }

        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if(i != result.size()-1) {
                System.out.print(",");
            }
        }



    }



}
