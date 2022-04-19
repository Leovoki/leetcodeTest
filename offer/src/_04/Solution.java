package _04;

public class Solution{
    public static void main(String[] args) {

    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean found = false;

        if(matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            int row = 0;
            int col = cols-1;
            while(row < rows && col >= 0) {
                if(matrix[row][col] == target) {
                    found = true;
                    break;
                } else if (matrix[row][col] > target) {
                    col--;
                } else {
                    row++;
                }
            }

        }
        return found;

    }


}
