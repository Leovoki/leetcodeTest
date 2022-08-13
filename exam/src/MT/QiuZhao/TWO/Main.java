package MT.QiuZhao.TWO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int k = cin.nextInt();
        cin.nextLine();
        String orders1 = cin.nextLine();
        char[] orders = orders1.toCharArray();
        int[][] matrix = new int[n][m];
        matrix[0][0] = 1;
        int x = 0;
        int y = 0;//表示当前位置
        int count = m*n-1;
        String thisOrder = null;
        int i = 0;
        for(i = 0; i < k; i++) {
            char order = orders[i];
            if(order == 'W') {
                y = y-1;
                count = getCount(matrix, x, y, count);
            }
            if(order == 'A') {
                x = x-1;
                count = getCount(matrix, x, y, count);
            }
            if(order == 'S') {
                y = y+1;
                count = getCount(matrix, x, y,count);
            }
            if(order == 'D') {
                x = x+1;
                count = getCount(matrix, x, y, count);
            }
            if(count == 0) {
                break;
            }
        }
        if(count == 0) {
           System.out.println("Yes");
           System.out.println(i+1);
        } else {
            System.out.println("No");
            System.out.println(count);
        }

    }

    private static int getCount(int[][] matrix, int x, int y, int count) {
        if(matrix[x][y] == 0) {
            matrix[x][y] = 1;
            count--;
        }
        return count;
    }

}
