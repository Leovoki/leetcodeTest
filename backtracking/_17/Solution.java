package _17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leovoki
 * @version 1.0 update on 2022/3/2
 */
public class Solution {
    static List<String> ans = new ArrayList<>();
    static String path = new String();
    public static void main(String[] args){
        String digits = new String("23");
        System.out.println(letterCombinations(digits));
    }


    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return ans;
        }
        int size = digits.length();
        String[] numMap = {"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] digitsList = digits.toCharArray();
        find(size, numMap, digitsList, 0);
        return ans;



    }

    public static void find(int size, String[] numMap, char[] digitsList, int index) {
        if(path.length() == size) {
            ans.add(new String(path));
            return;
        } else if (index > size -1) {
            return;
        }
        int nowVal = digitsList[index] - '0';
        char[] map = numMap[nowVal].toCharArray();


        for(int i = 0; i < map.length; i++) {
            if(path.length() == 0) {
                path = String.valueOf(map[i]);
            } else {
                path += String.valueOf(map[i]);
            }
            find(size, numMap, digitsList, index + 1);
            path = path.substring(0,path.length() - 1);
        }

    }
}
