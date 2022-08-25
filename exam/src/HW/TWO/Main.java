package HW.TWO;

import java.util.*;

public class Main {
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0,-1,0,1};
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = cin.nextInt();
            }
        }
    }

    public static int findMax(int[][] matrix) {
        int count = matrix.length;
        int index = 2;
        int[] area = new int[count*count+2];
        for(int row = 0; row < count; row++) {
            for(int col = 0; col < count; col++) {
                if(matrix[row][col] == 1) {
                    area[index] = dfs(row, col, index++,matrix);
                }
            }
        }
        int ans = 0;
        for(int x : area) ans = Math.max(ans, x);
        for(int row = 0; row < count; row++) {
            for(int col = 0; col < count; col++) {
                if(matrix[row][col] == 0) {
                    //Set
                }
            }
        }
    }

    public static int dfs(int row, int col, int index,int[][] matrix) {
        int ans = 1;
        matrix[row][col] = index;
        for(int move : beside(row, col, matrix)) {
            if(matrix[move / matrix.length][move % matrix.length] == 1) {
                matrix[move / matrix.length][move % matrix.length] = index;
                ans+=dfs(move / matrix.length, move % matrix.length, index, matrix);
            }
        }
        return ans;

    }

    public static List<Integer> beside(int row, int col, int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        for(int k = 0; k < 4; k++) {
            int nr = row + dr[k];
            int nc = col + dc[k];
            if(0 <= nr && nr < matrix.length && 0 <= nc && nc < matrix.length) {
                ans.add(nr * matrix.length + nc);
            }
        }
        return ans;
    }

}
