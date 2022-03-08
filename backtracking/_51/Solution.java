package _51;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static List<List<String>> ans = new ArrayList<>();

    public static void main(String[] args){
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        int[][] map = new int[11][11];
        backTracking(n,0,map);
        return ans;

    }


    public static void backTracking(int n, int deep,int[][] map) {
        if(deep == n) {
            paraseList(n,map);
            //ans.add(path);
            return;
        }


        for(int i = 0; i < n; i++) {
            if(isVaild(n,map,i,deep)) {
                map[deep][i] = 1;
                backTracking(n,deep+1,map);
                map[deep][i] = 0;
            }

        }
    }

    public static boolean isVaild(int n, int[][] map, int nowCol, int nowRow) {
        for(int i = 0; i < n; i++) {
            if(map[i][nowCol] == 1) {
                return false;
            }
        }
        int r = nowRow-1;
        for(int c = nowCol-1; c > -1&&r>=0; c--) {
            if(map[r][c] == 1) {
                return false;//左斜有
            }
            r--;
        }
        r = nowRow - 1;
        for(int c = nowCol + 1; c < n&&r>=0; c++) {
            if(map[r][c] == 1) {
                return false;
            }
            r--;
        }
        return true;
    }


    public static void paraseList(int n, int[][] map) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1) {
                    builder.append('Q');
                } else {
                    builder.append('.');
                }
            }
            list.add(builder.toString());


        }
        ans.add(list);
    }
}
