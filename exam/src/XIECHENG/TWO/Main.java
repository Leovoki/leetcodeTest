package XIECHENG.TWO;

import java.util.Scanner;

public class Main {
    private static int result = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t-- > 0) {
            result = Integer.MAX_VALUE;
            int[][] main = new int[2][2];
            int mainOne = 0;
            int otherOne = 0;
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < 2; j++) {
                    main[i][j] = cin.nextInt();
                    if(main[i][j] == 1) {
                        mainOne++;
                    }
                }
            }
            int[][] other = new int[2][2];
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < 2; j++) {
                    other[i][j] = cin.nextInt();
                    if(other[i][j] == 1) {
                        otherOne++;
                    }
                }
            }
            if(otherOne != mainOne) {
                System.out.println(-1);
            } else {
                find(main, other, 0);
                System.out.println(result);
            }


        }
    }
    public static void find(int[][] main, int[][] other, int count) {
        if(isSame(main, other)) {
            result = Math.min(count, result);
            return;
        }
        for(int row = 0; row < 2; row++) {
            for(int col = 0; col < 2; col++) {
                //选择一个位置
                for(int ways = 0; ways < 3; ways++) {
                    int temp = main[row][col];
                    if(ways == 0) {
                        //向上
                        if(row == 0) {
                            continue;
                        } else {
                            main[row][col] = main[1][col];
                            main[1][col] = temp;
                            find(main, other, count+1);
                            main[1][col] = main[row][col];
                            main[row][col] = temp;
                        }
                    } else if (ways == 1) {
                        //向左
                        if(col == 0) {
                            continue;
                        } else {
                            main[row][col] = main[row][0];
                            main[row][0] = temp;
                            find(main, other, count+1);
                            main[row][0] = main[row][col];
                            main[row][col] = temp;
                        }
                    } else if (ways == 2) {
                        //向下
                        if(row == 1) {
                            continue;
                        } else {
                            main[row][col] = main[1][col];
                            main[1][col] = temp;
                            find(main, other, count+1);
                            main[1][col] = main[row][col];
                            main[row][col] = temp;
                        }
                    } else {
                        //向右
                        if(col == 1) {
                            continue;
                        } else {
                            main[row][col] = main[row][1];
                            main[row][1] = temp;
                            find(main, other, count+1);
                            main[row][1] = main[row][col];
                            main[row][col] = temp;
                        }
                    }
                }
            }
        }

    }
    public static boolean isSame(int[][] main, int[][] other) {
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                if(main[i][j] != other[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
