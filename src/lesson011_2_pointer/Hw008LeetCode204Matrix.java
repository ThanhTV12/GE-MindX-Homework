package lesson011_2_pointer;

public class Hw008LeetCode204Matrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int rowLength = matrix.length;
            int colLength = matrix[0].length;
            int row = rowLength - 1;
            int col = 0;
            while(row >= 0 && col < colLength) {
                if(matrix[row][col] == target) {
                    return true;
                } else if(matrix[row][col] > target) {
                    row--;
                } else {
                    col++;
                }
            }
            return false;
        }
    }
}
