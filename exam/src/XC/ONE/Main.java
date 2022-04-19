package XC.ONE;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        //每行的*和n的数量的两倍
        //发现最后几层的共性是n次另外处理
        int col = 2 * n + 2 * n + 1;
        int row = 4 * n + 1;
        int i = 0;
        char[][] matrix = new char[row][col];
        int star = 0;
        int dot = 0;
        for (i = 0; i < 4 * n - n; i++) {
            star = 0;
            dot = 0;
            for (int j = 0; j < 4 * n; j++) {
                if (star < n) {
                    matrix[i][j] = '*';
                    star++;
                } else if (star == n && dot < 2 * n) {
                    matrix[i][j] = '.';
                    dot++;
                } else if (dot == 2 * n) {
                    matrix[i][j] = '*';
                    star++;
                }
                if (star == 4 * n) continue;
            }
        }
        int count = 0;
        for(i = i; i < 4*n; i++) {
            count++;
            star = n;
            dot = count;
            int end = 4*n-1;
            for(int front = 0; front < end;) {
                while(dot-- > 0) {
                    matrix[i][front++] = '.';
                    matrix[i][end--] = '.';
                }
                while(star-- >0) {
                    matrix[i][front++] = '*';
                    matrix[i][end--] = '*';
                }
                if(front <= end) {
                    matrix[i][front++] = '.';
                    matrix[i][end--] = '.';
                    continue;
                } else {
                    break;
                }
            }
        }
        for (i = 0; i < 4 * n; i++) {
            for (int j = 0; j < 4 * n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        //接着处理最后的

    }
}
